data segment
    message db 10,13,"**** Programme principal en cours **** $"
    deroute_msg db 10,13,"deroutement fait... $"
    debut_msg db 10,13,"****Debut du quantum de Temps Logiciel****",13,10,"$"
    sec_msg db "1 sec ecoulee...... $"
data ends

my_stack segment stack 'stack'
        dw 128 dup(?)
        TOP label word
my_stack ends

code segment
    assume cs:code, ds:data, ss:my_stack

output proc near
        mov ah,09h
        int 21h
        ret 
output endp

; Variables pour le comptage du temps
time_counter dw 0
deroute_done db 0

deroute proc near
        push ax
        push dx
        push ds

        ; Si le deroutement a d?j? ?t? affich?, sauter l'affichage
        cmp deroute_done, 1
        je skip_display

        ; Afficher le message de deroutement
        mov ax, data
        mov ds, ax
        mov dx, offset deroute_msg
        call output
        ; Marquer le deroutement comme d?j? affich?
        mov deroute_done, 1

skip_display:
        ; Incr?menter le compteur de temps (18,2 fois par seconde)
        inc time_counter
        cmp time_counter, 18 ; Environ une seconde (18 ticks)
        jb short skip_display

        ; R?initialiser le compteur de temps
        mov time_counter, 0

        ; Afficher les messages
        mov ax, data
        mov ds, ax
        mov dx, offset debut_msg
        call output
        mov cx, 3 ; Boucle pour afficher le message "1 sec ecoulee......" trois fois
display_loop:
        mov dx, offset sec_msg
        call output
        loop display_loop

        ; Restaurer les registres et revenir de l'interruption
        pop ds
        pop dx
        pop ax
        iret
deroute endp

installation proc near
        push ds
        mov ax,cs
        mov ds,ax
        mov dx,offset deroute
        mov ax,251Ch
        int 21h
        pop ds
        ret
installation endp

start:
        mov ax, data
        mov ds, ax
        mov ax, my_stack
        mov ss, ax
        mov sp, TOP
        call installation
        mov ax, 3
  loopa:
    mov dx, offset message     ; Charge l'adresse du message dans DX
    call output                ; Affiche le message
    mov cx, 3C0h               ; Initialise CX avec la valeur 3C0h

boucle_interne:
    inc bl                     ; Incr?mente BL
    mov ax, 3d09h              ; Charge la valeur 3d09h dans AX (valeur arbitraire)

attente: 
    dec ax                     ; D?cr?mente AX
    jnz attente                ; Saute ? "attente" si AX n'est pas nul
                               ; (cr?e une boucle d'attente en temps)
    loop boucle_interne        ; D?cr?mente CX et saute ? "boucle_interne" tant que CX n'est pas nul
    jmp loopa                  ; Saute ? "loopa" (boucle infinie)

code ends
        end start

