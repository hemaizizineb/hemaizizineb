data segment
    message db 10,13,"**** Programme principal en cours **** $" ; Message principal
    deroute_msg db 10,13,"deroutement fait... $"              ; Message de d?routement
    debut_msg db 10,13,"****Debut du quantum de Temps Logiciel****",13,10,"$" ; Message de d?but de quantum
    sec_msg db "1 sec ecoulee...... $"                        ; Message de d?compte de la seconde
data ends

my_stack segment stack 'stack'
    dw 128 dup(?)        ; D?finition du segment de pile
    TOP label word       ; Pointeur de sommet de pile
my_stack ends

code segment
    assume cs:code, ds:data, ss:my_stack ; Assurer les segments de code, de donn?es et de pile

output proc near
    mov ah, 09h      ; Chargement de la fonction d'affichage du DOS
    int 21h          ; Appel de l'interruption DOS pour afficher la cha?ne
    ret              ; Retour de la proc?dure
output endp

; Variables pour le comptage du temps
time_counter dw 0      ; Compteur de temps
deroute_done db 0      ; Indicateur de d?routement affich?

deroute proc near
    push ax           ; Sauvegarde des registres utilis?s
    push dx
    push ds

    ; Si le d?routement a d?j? ?t? affich?, sauter l'affichage
    cmp deroute_done, 1
    je skip_display

    ; Afficher le message de d?routement
    mov ax, data      ; Chargement du segment de donn?es
    mov ds, ax
    mov dx, offset deroute_msg  ; Chargement de l'adresse du message de d?routement
    call output       ; Appel de la proc?dure d'affichage
    ; Marquer le d?routement comme d?j? affich?
    mov deroute_done, 1

skip_display:
    ; Incr?menter le compteur de temps (18,2 fois par seconde)
    inc word ptr ds:[time_counter]
    cmp word ptr ds:[time_counter], 5400 ; Environ 5 minutes (300 secondes * 18)
    jb short skip_reset_counter

    ; Si 5 minutes se sont ?coul?es, terminer le programme
    mov ah, 4Ch       ; Chargement de la fonction de terminaison du programme DOS
    int 21h           ; Appel de l'interruption DOS pour terminer le programme

skip_reset_counter:
    ; Afficher les messages
    mov ax, data      ; Chargement du segment de donn?es
    mov ds, ax
    mov dx, offset debut_msg  ; Chargement de l'adresse du message de d?but de quantum
    call output       ; Appel de la proc?dure d'affichage
    mov cx, 3         ; Boucle pour afficher le message "1 sec ?coul?e" trois fois
display_loop:
    mov dx, offset sec_msg    ; Chargement de l'adresse du message de seconde ?coul?e
    call output       ; Appel de la proc?dure d'affichage
    loop display_loop ; D?cr?mente CX et saute ? "display_loop" tant que CX n'est pas nul

    ; Restaurer les registres et revenir de l'interruption
    pop ds            ; Restauration des registres
    pop dx
    pop ax
    iret              ; Retour de l'interruption

deroute endp

installation proc near
    push ds           ; Sauvegarde des registres utilis?s
    mov ax, cs
    mov ds, ax
    mov dx, offset deroute
    mov ax, 251Ch     ; Chargement de la fonction d'installation de l'interruption
    int 21h           ; Appel de l'interruption DOS pour installer l'interruption 1Ch
    pop ds            ; Restauration des registres
    ret               ; Retour de la proc?dure
installation endp

start:
    mov ax, data      ; Chargement du segment de donn?es
    mov ds, ax
    mov ax, my_stack  ; Chargement du segment de pile
    mov ss, ax
    mov sp, TOP       ; Initialisation du pointeur de pile
    call installation ; Appel de la proc?dure d'installation de l'interruption 1Ch

    ; Afficher le message principal
    mov dx, offset message
    call output

    ; Boucle d'attente d'une seconde (environ 18,2 ticks par seconde)
    mov cx, 5400      ; 5 minutes en ticks (300 secondes * 18)
wait_loop:
    mov ax, 3d09h    ; Chargement de la fonction d'attente du DOS
    int 21h          ; Appel de l'interruption DOS pour l'attente
    loop wait_loop   ; D?cr?mente CX et saute ? "wait_loop" tant que CX n'est pas nul

code ends
    end start
