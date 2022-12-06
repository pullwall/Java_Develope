.data 
    msg1 : .asciiz "Please, type a number for g: "
    msg2 : .asciiz "Please, type a number for h: "
    msg3 : .asciiz "The 1st result is "
    msg4 : .asciiz "The 2nd result is "
    endLine : .asciiz "\n"

.text
main :
# set A, B like for
    addi $t0, $zero, 0              #int i = 0;
    addi $t1, $zero, 10             #i < 10
Loop :
    sll $t2, $t0, 2
    addi $t0, $t0, 1                #i++
    add $t3, $t2, $s6
    add $t4, $t2, $s7
    sw $t0, 0($t3)                  #A[i] = i+1
    sw $t0, 0($t4)                  #B[i] = i+1    
    beq $t0, $t1, Exit               #if i+1 = 10, j Exit
    j Loop
Exit :
# print msg1
    la $a0, msg1                    
    li $v0, 4
    syscall
# scan g
    li $v0, 5
    syscall
    add $s1, $zero, $v0
# print msg2
    la $a0, msg2
    li $v0, 4
    syscall
# scan h
    li $v0, 5
    syscall
    add $s2, $zero, $v0
# calculate first f
    add $t0, $s7, $s1
    lw $t1, 0($t0)
    sub $s0, $zero, $s2
    add $s0, $s0, $t1
# print first f
    la $a0, msg3
    li $v0, 4
    syscall
    add $a0, $zero, $s0
    li $v0, 1
    syscall
# calculate second f
    add $t0, $s7, $s2
    lw $t1, 0($t0)
    addi $t1, $t1, 1
    add $t0, $s6, $t1
    lw $s0, 0($t0)
# print first f
    la $a0, msg4
    li $v0, 4
    syscall
    add $a0, $zero, $s0
    li $v0, 1
    syscall
# print endline and Exit
    la $a0, endLine
    li $v0, 4
    syscall
    li $v0, 10
    syscall