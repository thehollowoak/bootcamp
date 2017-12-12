
VALUES = {'2'=>2, '3'=>3, '4'=>4, '5'=>5, '6'=>6, '7'=>7, '8'=>8, '9'=>9, 'T'=>10, 'J'=>'Jack', 'Q'=>'Queen', 'K'=>'King', 'A'=>'Ace'}
SUITS = {'C'=>'Clubs', 'S'=>'Spades', 'H'=>'Hearts', 'D'=>'Diamonds'}

class Card
  attr_reader :value
  attr_reader :suit
  def initialize (value, suit)
    set_value_from_char(value)
    set_suit_from_char(suit)
  end
  def set_value_from_char (value)
    @value = VALUES[value]
  end
  def set_suit_from_char (suit)
    @suit = SUITS[suit]
  end
  def get_value_as_int
    case value
      when 'Ace'
        return 14
      when 'King'
        return 13
      when 'Queen'
        return 12
      when 'Jack'
        return 11
      else
        return value
    end
  end
  def to_s
    value.to_s + ' of ' + suit
  end
end
