(ns kata-diamond.core)

(defn- create-basic-char-seq [letter]
  (range (int \A) (inc (int (.charAt letter 0)))))

(defn- char-seq-to-string [seq]
  (apply str (map (comp str char) seq)))

(defn- concat-seq-adding-returns [seq]
  (apply str (map (fn [word] (str word "\n")) seq)))


(defn create-cap-i-cua [word]
  (str word (apply str (rest (reverse word)))))

(defn create-letter-seq [letter]
  (create-cap-i-cua (char-seq-to-string (create-basic-char-seq letter))))

(defn create-reverse-letter-seq [letter]
  (create-cap-i-cua (char-seq-to-string (reverse (create-basic-char-seq letter)))))

(defn replace-different-letters-with-space [word letter-to-filter]
  (clojure.string/replace word (re-pattern (str "[^" letter-to-filter "]")) " "))

(defn create-diamond [letter]
  (let [seq-letter-to-choose (create-letter-seq letter)
        seq-raw-diamond-row   (create-reverse-letter-seq letter)]
    (concat-seq-adding-returns (map (partial replace-different-letters-with-space seq-raw-diamond-row) (map str seq-letter-to-choose)))))
