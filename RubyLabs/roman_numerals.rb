# up to 3000
NUMERALS = {1000 => 'M', 9000 => 'CM', 500 => 'D', 400 => 'CD', 100 => 'C', 90 => 'XC', 
            50 => 'L', 40 => 'XL', 10 => 'X', 9 => 'IX', 5 => 'V', 4 => 'IV', 1 => 'I'}

def roman_numeral_converter(num)
    roman = ""
    NUMERALS.each do |n, r|
        (num / n).times {roman << r; num -= n}
    end
    roman
end