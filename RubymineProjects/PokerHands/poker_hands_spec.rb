require 'rspec'
require_relative 'poker_hands.rb'

describe 'poker_hands' do

  it 'should set hand from string array' do
    black = PokerPlayer.new %w[TH, 7S, 9D, 8S, 6C]
    expect(black.hand.cards[0].to_s).to eq '10 of Hearts'
  end
  it 'should sort hand once set' do
    black = PokerPlayer.new %w[2H, 7S, 9D, KS, 6C]
    expect(black.hand.cards[0].to_s).to eq 'King of Spades'
  end
  it 'should set the rank' do
    black = PokerPlayer.new %w[TH, 7S, 9D, 8S, 6C]
    expect(black.find_rank).to eq 'Straight'
  end

end