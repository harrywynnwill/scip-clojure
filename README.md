# scip-in-clojure

Killing 2 birds with one stone.

Learning Emacs while going through the famous SCIP

USEFUL COMMANDS IN EMACS (for me)

C-x cut text
C-c copy text
C-v paste text
C-w kill
C-y yank - emacs paste 
M-y yank next - go through the text saved

C-x C-b view the list of open buffers in the mini buffer
C-x C-a go to the beginning of a line
C-x C-o swith to the next open buffer

C-c 



USEFUL CIDER COMMANDS

Enable `cider-mode` and `cider-jack-in`

C-c C-e evaluates the preceding form in the minibuffer
C-x M-p prettyfy fo
C-c C-k loads the current buffer into the repl

NOTES


Viewing evaluation in terms of a tree, we can imagine that the values of the operands percolate upwards. Starting with the terminal nodes and then combining at higher and higher levels.

The environment provides the context in which evaluation takes place.

Numbers and arithemtic operations are primitive data

procedure defintions - abstaction technique compound operation can be given a name and referred to.

compound procedure e.g. (defn square [x] (* x x ))
primitive procedure e.g. (+ )

(define (sum-of-squares x y)
  (+ (square x) (square y)))

(define (f a)
  (sum-of-squares (+ a 1) (* a 2)))


Substitution model for procedure application is described below
(f 5) ---> (sum-of-squares (+ 5 1) (* 5 2)) ---> (+ (square 6) (square 10)) ---> (+ 36 100) ---> 136

normal-order evalutaion "fully expand and then reduce"
Instead it would first substitute operand expressions for parameters until it obtained an expression involving only primitive operators, and would then perform the evaluation.

(sum-of-squares (+ 5 1) (* 5 2))

(+    (square (+ 5 1))      (square (* 5 2))  )

(+    (* (+ 5 1) (+ 5 1))   (* (* 5 2) (* 5 2)))


(+ 5 1) is passed through until only primitive operands are left and then it is evaluated/

mathematical functions and computer procedures are different.

e.g. pseudo mathematical function for square root...

(define (sqrt x)
  (the y (and (>= y 0)
              (= (square y) x))))

mathmatical functions do not describe the procedure - it tells us almost nothing about how to actually get the square root of a number.

(mathematical) functions describe property of things - declative
(computer) procedures describe how to do things - imperative

Newtons method - procedural method using successive approximations.

whenever we perform a guess for `y` for the value of square root `x`, we can perform a simple manipulation to get a better guess.
(






