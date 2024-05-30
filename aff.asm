data segment  
    N db ? ; variable qui va contenir le num?ro du vecteur suivant  
    tableau db '0123456789ABCDEF' ; table de correspondance
    espace db "  : $" ; pour s?parer le IP du CS lors de l'affichage
    saut db 10, 13, '$'
    msg db "Taper 'O' pour afficher les vecteurs suivants$"
data ends

code segment
    Assume cs:code, ds:data

    effaceEcran proc                  
        mov ax, 3
        int 10h
        ret
    effaceEcran endp 
                        
    setCursorPosition proc
        mov ah, 2
        mov bh, 0 
        inc dh       ; num de ligne
        mov dl, 30   ; num de colonne
        int 10h      
        ret
    setCursorPosition endp 
       
    afficherChaine proc
        push bp
        mov bp, sp
        mov dx,[bp+4]
        mov ah, 9h
        int 21h
        pop bp
        ret
    afficherChaine endp

    afficherCaractereHexa proc near
        push bp
        mov bp, sp
        mov ax, [bp+4]
        lea bx, tableau ; table qui contient les codes ascii des caracteres hexa 0 a F
        xlat          
        mov ah, 0eh 
        int 10h
        pop bp
        ret 2
    afficherCaractereHexa endp 

    afficherAdresseRoutineN proc
        push bp
        mov bp, sp

        ; Adresse IP
        mov ax, dx
        call afficherCaractereHexa
        mov al, espace
        call afficherChaine

        ; Adresse CS
        mov ax, es
        call afficherCaractereHexa

        pop bp
        ret 2
    afficherAdresseRoutineN endp

    afficherVingsVecteurs proc
        mov cx, 20  ; nombre de vecteurs ? afficher

        vecSuivant:
            call setCursorPosition

            ; Affichage CS:IP
            mov al, N ; N contient le num?ro du vecteur suivant ? afficher
            mov ah, 35h
            int 21h
            call afficherAdresseRoutineN
           
            inc N  ; Incr?menter le num?ro du vecteur suivant

            loop vecSuivant

        ret
    afficherVingsVecteurs endp 

start:
    mov ax, data
    mov ds, ax

    mov N, 0
    encore:
        call afficherVingsVecteurs

        mov dx, offset saut
        call afficherChaine

        mov dx, offset msg
        call afficherChaine

        mov ah, 1h 
        int 21h   

        cmp al, 'o' 
        jnz fin

        call effaceEcran

        jmp encore

    fin:
    mov ah, 4ch
    int 21h

code ends
end start
