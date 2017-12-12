require_relative 'card_hand.rb'

class Poker
  attr_accessor :black
  attr_accessor :white
end

class PokerPlayer
  attr_accessor :hand
  attr_reader :rank
  def initialize (cards)
    @hand = Hand.new
    set_and_sort_hand cards
  end
  def set_and_sort_hand (cards)
    @hand.set_hand_string_array(cards)
    @hand.sort_hand_by_value
  end

  def find_rank
    if is_straight
      @rank = 'Straight'
    else
      @rank = 'High Card'
    end
  end

  def is_straight
    for i in 1..4
      if @hand.cards[i].get_value_as_int != @hand.cards[i-1].get_value_as_int - 1
        return false
      end
    end
    return true
  end
end

