INCLUDE Irvine32.inc 
.386
.model flat, stdcall ;we always use flat memory model for 32 bits programs 
.stack 4096
;....segments
.data   ;data section
sum DWORD 0  ; VARIABLE NAME SUM IN 32 BITS

.code  ;code section

main PROC ;main procedure
mov eax,5   ;store 5 to eax
add eax,6   ; add 6 to eax and store the sum in eax
inc eax     ;eax plus 1
mov sum, eax  ; store eax sum into sum
    exit   ;exit
 main ENDP ; end of the main procedure
 END main  ; end of program


