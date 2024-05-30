
data segment  
N db ? ; var qui va contenir le num du vecteur suivant  
 
tableau db '0123456789ABCDEF' ; table de correspendance

espace db "  : $" ; pour separer le ip du cs lors de l affichage
saut db 10, 13, '$'
msg db "Les vecteurs sont afficher $"

data ends
 
mapile segment stack
dw 128 dup(?)
tos label word
mapile ends    

code segment
    Assume cs:code, ds:data, ss:mapile
                                       
       effaceEcran proc                  
       mov ax, 3
       int 10h
       ret
       effaceEcran endp 
                        
       setCursorPosition proc
       
       mov ah,2
       mov bh, 0 
       inc dh       ; num de ligne
       mov dl, 30   ; num de colonne
       int 10h      
       
       ret
       setCursorPosition endp 
       
       
       getCursorPosition proc
       push cx
       mov ah, 3h
       int 10h 
       pop cx ; dx contient les num de lign et col courantes
       ret 
       getCursorPosition endp    
       
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
  
; cette proc affiche un vecteur (ip-cs) en exa  ;

    afficherAdresseRoutineN proc
     push bp
     mov bp, sp
     xor ax, ax
     mov dx, [bp+4] 
      
     
   ;valeur des 4 bits de poids fort de l'octet fort de l'adresse
      mov al, dh
      shr al, 4    
      push ax
      call afficherCaractereHexa
      
  
  
  ;valeur des 4 bits de poids faible de de l'octet fortl'adresse
      mov al, dh
      and al, 0fh  
      push ax
      call afficherCaractereHexa  
  
  ;valeur des 4 bits de poids fort de de l'octet faible de l'adresse        
      mov al, dl
      shr al, 4    
      push ax
      call afficherCaractereHexa 

  ;valeur des 4 bits de poids faible de de l'octet faible de l'adresse
  
      mov al, dl
      and al, 0fh 
      push ax 
      call afficherCaractereHexa   
          
     pop bp
  ret 2
    
  afficherAdresseRoutineN endp   

                                            
                                            
                                            
                                            
                                            
                                            
                                            
  
; cette proc affiche les 20 prochains vect d'its ;
    afficherVingsVecteurs proc
       
       
       mov cx, 20
                                   
       vecSuivant:
       
       call setCursorPosition
       
       
       
       
       mov al, N ; N contient le numero du vecteur suivant a afficher
       mov ah, 35h
       int 21h
       
       
       push bx ; CONTIENT IP
       call afficherAdresseRoutineN
        
       mov dx, offset espace
       push dx
       call afficherChaine
     
       push es ; CONTIENT CS
       call afficherAdresseRoutineN   
       
       inc N  
       call getCursorPosition
       
       loop vecSuivant
       
                       
      
    ret
    afficherVingsVecteurs endp 

  

; ---------------------------------------------- ;
;           Programme appelant
; ---------------------------------------------- ;
start:mov ax, data
      mov ds, ax
      mov ax, mapile
      mov ss, ax
      lea sp, tos
      
      
   mov N, 0
   encore:
   call afficherVingsVecteurs
   
   
   mov dx, offset saut
   push dx
   call afficherChaine
   
   
   mov dx, offset msg
   push dx
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

