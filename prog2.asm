data segment
    PROG1 db "Tache 1 en cours d'execution...",10,13,"$" ; Message pour la t?che 1
    PROG2 db "Tache 2 en cours d'execution...",10,13,"$" ; Message pour la t?che 2
    PROG3 db "Tache 3 en cours d'execution...",10,13,"$" ; Message pour la t?che 3
    PROG4 db "Tache 4 en cours d'execution...",10,13,"$" ; Message pour la t?che 4
    PROG5 db "Tache 5 en cours d'execution...",10,13,"$" ; Message pour la t?che 5
    NEWLINE db 10,13,"$"                                 ; Cha?ne pour un saut de ligne
    INSTALLED db "Deroutement fait",10,13,"$"            ; Message d'installation
    timer_counter dw 0                                   ; Compteur de temps pour compter 5 secondes
    current_task db 0                                    ; Indicateur de la t?che actuelle
data ends

code segment
    assume cs: code, ds: data

    ; Proc?dure d'installation de la routine d'interruption
    instalation proc near
        push ds
        mov ax,cs
        mov ds,ax
        mov dx,offset deroute
        mov ax,251CH
        int 21H
        pop ds
        mov dx,offset INSTALLED
        mov ah,09h
        int 21h
        ret
    instalation endp

    ; Proc?dures pour afficher les messages de chaque t?che
    PRO1 proc near
        mov dx,offset PROG1
        mov ah,09h
        int 21h
        ret
    PRO1 endp

    PRO2 proc near
        mov dx,offset PROG2
        mov ah,09h
        int 21h
        ret
    PRO2 endp

    PRO3 proc near
        mov dx,offset PROG3
        mov ah,09h
        int 21h
        ret
    PRO3 endp

    PRO4 proc near
        mov dx,offset PROG4
        mov ah,09h
        int 21h
        ret
    PRO4 endp

    PRO5 proc near
        mov dx,offset PROG5
        mov ah,09h
        int 21h
        ret
    PRO5 endp

    ; Proc?dure pour afficher un saut de ligne
    NEWLINE_PROC proc near
        mov dx,offset NEWLINE
        mov ah,09h
        int 21h
        ret
    NEWLINE_PROC endp

    ; Routine d'interruption p?riodique 1CH
    deroute proc near
        push ax
        push bx
        push cx
        push dx

        ; Incr?mente le compteur de temps
        inc word ptr [timer_counter]
        cmp word ptr [timer_counter], 91 ; Environ 5 secondes (18.2 ticks/sec * 5 sec)
        jne skip_task

        ; R?initialise le compteur de temps
        mov word ptr [timer_counter], 0

        ; Passe ? la t?che suivante
        inc byte ptr [current_task]
        cmp byte ptr [current_task], 5
        jle call_task
        mov byte ptr [current_task], 1
        call NEWLINE_PROC  ; Ajoute un saut de ligne avant de revenir ? la t?che 1

    call_task:
        ; Appelle la t?che appropri?e selon la valeur de current_task
        cmp byte ptr [current_task], 1
        je execute_task1
        cmp byte ptr [current_task], 2
        je execute_task2
        cmp byte ptr [current_task], 3
        je execute_task3
        cmp byte ptr [current_task], 4
        je execute_task4
        cmp byte ptr [current_task], 5
        je execute_task5
        jmp skip_task

    execute_task1:
        call PRO1
        jmp skip_task

    execute_task2:
        call PRO2
        jmp skip_task

    execute_task3:
        call PRO3
        jmp skip_task

    execute_task4:
        call PRO4
        jmp skip_task

    execute_task5:
        call PRO5

    skip_task:
        pop dx
        pop cx
        pop bx
        pop ax
        iret
    deroute endp

start:
    mov ax, data
    mov ds, ax

    mov bl, 0H
    mov bh, 1h
    mov ax, 3 
    int 10H ; Efface l'?cran en utilisant l'interruption 10H
    call instalation

infinie_et_au_dela:
    ; Boucle infinie principale
    jmp infinie_et_au_dela

code ends
    end start

