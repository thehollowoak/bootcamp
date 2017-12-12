require_relative 'card.rb'

class Hand
  attr_reader :cards
  def initialize
    @cards = []
  end
  def set_hand_string_array (cards)
    cards.each do |card|
      @cards << Card.new(card[0],card[1])
    end
  end
  def sort_hand_by_value
    @cards = @cards.sort do |a, b|
      b.get_value_as_int <=> a.get_value_as_int
    end
  end
end