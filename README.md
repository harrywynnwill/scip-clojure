# scip-in-clojure *a work in progress

Killing 2 birds with one stone.

Learning Emacs while going through the famous SCIP

I'm taking notes but mainly as a learning aid - so in most parts it probably reads like garbage.

EMACS Stuff (for me)
//TODO
* Learn Paredit.

Emacs is all about key bindings. Read further into it to learn more... The tutorial on Emacs and the start of Clojure for the brave and true is where I have started reading.

I'm using a Mac. ctrl and alt are the two most important keys in emacs. On a Mac alt + 3 is how you get a '#'. In Emacs it translates to meta + 3 which does not equal '#'. To get round this, add this to your init.el file.

```;; Allow hash to be entered  
(global-set-key (kbd "M-3") '(lambda () (interactive) (insert "#")))
```

`Variable binding depth exceeds max-specpdl-size` in elisp I think means stackoverflow a recursive call to nowhere.

# Adding a spellcheck to Emacs (only as I'm posting to GitHub)



# MarkDown preview to see it as it is on Github.


I'm going to give http://www-sop.inria.fr/members/Manuel.Serrano/flyspell/flyspell.html a go. It seems to correct words on-the-fly. I'm probably not gonna re-read this, so its a good solution.

add this to your .init.el


```
;;Add flyspell on-the-fly spelling...
(autoload 'flyspell-mode "flyspell" "On-the-fly spelling checker." t)
(autoload 'flyspell-delay-command "flyspell" "Delay on command." t)
(autoload 'tex-mode-flyspell-verify "flyspell" "" t) 

```

The documenation recommends aspell

C-x cut text

C-c copy text

C-v paste text

C-w kill

C-y yank - emacs paste 

M-y yank next - go through the text saved

C-x C-b view the list of open buffers in the mini buffer

C-x C-a go to the beginning of a line

C-x C-o swith to the next open buffer

Enable NeoTree and use H to show hidden files/folders

g to refresh 

## USEFUL CIDER COMMANDS

Enable `cider-mode` and `cider-jack-in`

C-c C-e evaluates the preceding form in the minibuffer

C-x M-p prettyfy fo

C-c C-k loads the current buffer into the repl

## NOTES


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
```
(sum-of-squares (+ 5 1) (* 5 2))

(+    (square (+ 5 1))      (square (* 5 2))  )

(+    (* (+ 5 1) (+ 5 1))   (* (* 5 2) (* 5 2)))
```

`(+ 5 1)` is passed through until only primitive operands are left and then it is evaluated/

mathematical functions and computer procedures are different.

e.g. pseudo mathematical function for square root...
```
(define (sqrt x)
  (the y (and (>= y 0)
              (= (square y) x))))
```
mathmatical functions do not describe the procedure - it tells us almost nothing about how to actually get the square root of a number.

(mathematical) functions describe property of things - declative
(computer) procedures describe how to do things - imperative

Newtons method - procedural method using successive approximations.

whenever we perform a guess for `y` for the value of square root `x`, we can perform a simple manipulation to get a better guess.


The square root problem breaks up naturally into a number of subproblems. 1. How to tell whether a guess is good enough. 2. how to improve. Each of these tasks is accomplished by a seperate procedure. Each procedure accomplishes an identifable task.

We are not concerned with how the procedure computes the square result, only with the fact it computes the square.

good-enough? is not concerned about square. square is a procedural abstraction. At this level of abstraction any procedure that computes the square is equally good.

so a procedure definition should be able to supress detail. A user should not need to know how the procedure is implemented in order to use it.

procedure names should be independent of the parameter name  




