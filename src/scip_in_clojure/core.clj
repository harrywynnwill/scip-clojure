(ns scip-in-clojure.core)

;;Exercise 1.1.  Below is a sequence of expressions. What is the result printed by the interpreter in response to each expression? Assume that the sequence is to be evaluated in the order in which it 

10

(+ 5 3 4) ;; 12

(- 9 1) ;; 8
(/ 6 2) ;; 2

(+ (* 2 4) (- 4 6)) ; (+ 8 -2) -> 6
(def a 3) ;a
(def b (+ a 1)) ; 4 -> b
(+ a b (* a b)) ; 19
(= a b) ;false
(if (and (> b a) (< b (* a b)))
    b
    a) ;4
(cond (= a 4) 6
      (= b 4) (+ 6 7 a)
      :else 25) ;16

(+ 2 (if (> b a) b a)) ;6

(* (cond (> a b) a
         (< a b) b
         :else -1)
   (+ a 1)) ; (* 4 4) -> 16

;; Exercise 1.2.  Translate the following expression into prefix form

;; 5 + 4 + (2 - (3 - (6 + 4/5)))  (6.8) -> 3.8 -> 1.8 -> 5.8 -> 10.8
;;;----------------------------
;; 3 (6 - 2)(2 - 7)


(/ (+ 5 4 (- 2 (- 3 (+ 6 (/ 4 5))))) ; 74/7
   (* 3 (- 6 2) (- 2 7))) ;-60 ---> -37/150


;;Exercise 1.3.  Define a procedure that takes three numbers as arguments and returns the sum of the squares of the two larger numbers.
(defn square [arg1] 
  (* arg1 arg1))

(= (square 6) 36)

(defn sum-of-square-largest-combo [arg1 arg2 arg3] 
  (cond 
   (< arg1 (and arg2 arg3)) (+ (square arg2) (square arg3))
   (< arg2 (and arg1 arg3)) (+ (square arg1) (square arg3))
   (< arg3 (and arg1 arg2)) (+ (square arg1) (square arg2)))) 


;;Exercise 1.4.  Observe that our model of evaluation allows for combinations whose operators are compound expressions. Use this observation to describe the behavior of the following procedure:

(= (sum-of-square-largest-combo 1 2 3) 13)

;; (define (a-plus-abs-b a b)
  ;; ((if (> b 0) + -) a b))

;; it defines a function that adds a to an absolute value of b. It must evaluate the boolean within the if statement to determine wether B is is negative or positive. 

(defn a-plus-abs-b [a b]
  ((if (> b 0) + -) a b));; written the same in clojure

;; Exercise 1.5.  Ben Bitdiddle has invented a test to determine whether the interpreter he is faced with is using applicative-order evaluation or normal-order evaluation. He defines the following two procedures:

;; (define (p) (p))

;; (define (test x y)
;;   (if (= x 0)
;;       0
;;       y))

;; Then he evaluates the expression

;; (test 0 (p))

;; What behavior will Ben observe with an interpreter that uses applicative-order evaluation? What behavior will he observe with an interpreter that uses normal-order evaluation? Explain your answer. (Assume that the evaluation rule for the special form if is the same whether the interpreter is using normal or applicative order: The predicate expression is evaluated first, and the result determines whether to evaluate the consequent or the alternative expression.)

;;using applicative evaluation: the test and the recursive (p) function will all be evaluated... Meaning the test will evaluate to zero and the (p) function will make a never ending call to itself.
;; using normal-order evaluation: The if statement in the test function will evaluate first. The boolean will return true and the function will return 0 with no call on the recursive (p) function. "in normal order evaluation the interpreter will substitue operand expressions for parameters.



;1.1.7  Example: Square Roots by Newton's Method

;see Notes for Newton's Method in lay"persons" terms. 

(defn average [x y]
(float (/ (apply + [x y]) 2))) ;; average function

;radicant = number whose square root we are trying to compute, x in our case.

(defn improve? [guess x]
  (average guess (/ x guess))) ; a guess is improved by averaging it with quotient of the radicand and the old guess.



(= (average 3 7) 5)
; a Quotient in maths is the quantity produced from the division of 2 numbers.


(defn abs [number] 
(max number (- number))) ; define an absolute method to return positives

(=(abs -2) 2)
 
(defn good-enough? [guess, x] 
  (< (abs (- (square guess) x)) 0.001))

(= (good-enough? 3 9.001) true)



(defn sqrt-iter [guess x]
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve? guess x) x)))


(sqrt-iter 3 1)

(defn sqrt [x]
  (sqrt-iter 1 x))

(sqrt 3)
