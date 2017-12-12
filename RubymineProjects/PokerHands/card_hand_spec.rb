require 'rspec'
require_relative 'card_hand.rb'

describe 'Hand' do

  it 'should set a hand from a string array' do
    hand = Hand.new
    hand.set_hand_string_array %w[TH, 7S, 9D, 8S, 6C]
    expect(hand.cards[0].to_s).to eq '10 of Hearts'
  end
  it 'should sort the hand by value' do
    hand = Hand.new
    hand.set_hand_string_array %w[2H, 7S, 9D, QS, 6C]
    hand.sort_hand_by_value
    expect(hand.cards[0].to_s).to eq 'Queen of Spades'
  end
end