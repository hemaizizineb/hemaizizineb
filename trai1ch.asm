data segment
    message db 10, 13, "Exemple d'utilisation de l'interruption 1CH pour le timing$"
data ends

code segment
    assume cs:code, ds:data

    ; Proc?dure pour afficher un message
    output proc near
        mov ah, 09h
        int 21h
        ret 
    output endp

    ; Routine d'interruption 1CH
    deroute proc near
        push ax
        push dx

        ; Afficher le message
        mov dx, offset message 
        call output 

        pop dx
        pop ax
        iret
    deroute endp

    ; Installation de l'interruption 1CH
    installation proc near
        push ds
        mov ax, cs
        mov ds, ax
        mov dx, offset deroute
        mov ax, 251CH
        int 21H
        pop ds
        ret
    installation endp

    start:
        mov ax, data
        mov ds, ax

        ; Installation de l'interruption 1CH
        call installation

        ; Autres instructions du programme ici...

code ends
end start

