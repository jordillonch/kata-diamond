(ns kata-diamond.core-test
  (:use midje.sweet)
  (:use [kata-diamond.core]))

; A
;B B
; A

;  A
; B B
;C   C
; B B
;  A

(facts "print just diamond"
       (fact "cap-i-cua helper"
             (create-cap-i-cua "A") => "A"
             (create-cap-i-cua "BA") => "BAB"
             (create-cap-i-cua "CBA") => "CBABC"
             (create-cap-i-cua "ABC") => "ABCBA")

       (fact "print-letter-seq helper"
             (create-letter-seq "A") => "A"
             (create-letter-seq "B") => "ABA"
             (create-letter-seq "C") => "ABCBA")

       (fact "print-reverse-letter-seq helper"
             (create-reverse-letter-seq "A") => "A"
             (create-reverse-letter-seq "B") => "BAB"
             (create-reverse-letter-seq "C") => "CBABC")

       (fact "replace-different-letters-with-space"
             (replace-different-letters-with-space "BAB" "A") => " A "
             (replace-different-letters-with-space "BAB" "B") => "B B"
             (replace-different-letters-with-space "CBABC" "C") => "C   C")

       (fact "print some diamonds"
             (create-diamond "A") => "A\n"
             (create-diamond "B") => " A \nB B\n A \n"
             (create-diamond "C") => "  A  \n B B \nC   C\n B B \n  A  \n"))
