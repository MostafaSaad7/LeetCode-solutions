func checkValidString(s string) bool {
    var numOpen, numClose, numStar int

    numOpen, numClose, numStar = 0, 0, 0
    for _, c := range s {
        switch c {
            case '(':
                numOpen++
            case ')':
                numClose++
            case '*':
                numStar++
        }
        if numClose > numOpen + numStar {
            return false
        }
    }

    numOpen, numClose, numStar = 0, 0, 0
    for i := len(s)-1; i >= 0; i-- {
        switch c := s[i]; c {
            case '(':
                numOpen++
            case ')':
                numClose++
            case '*':
                numStar++
        }
        if numOpen > numClose + numStar {
            return false
        }
    }

    return true
}