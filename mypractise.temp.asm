INCLUDE c:\Users\27637\.vscode\extensions\istareatscreens.masm-runner-0.9.1\native\irvine\Irvine32.inc 

;....segments
.data  
myList DWORD 1,2,3,4,5   ;ARRAY OF 5 WORDS
myListSize =($-mylist)

STRING BYTE 'hello'
STRING_len = ($-STRING) ; FOR BYTE

NUMBER WORD 1000h,2000h,3000h,4000h 
NUMBERSize = ($-NUMBER)/2  ;FOR WORD we divide by 2

sum DWORD 10000000h,200000000h 
sumSize = ($- sum)/4  ; for dword we divide by 4

