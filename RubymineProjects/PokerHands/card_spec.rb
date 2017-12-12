require 'rspec'
require_relative 'card.rb'

describe 'card' do

  it 'should initialize value and suit' do
    card = Card.new('5','C')
    expect(card.to_s).to eq '5 of Clubs'
  end
  it 'should be able to return the value as an int' do
    card = Card.new('K','C')
    expect(card.get_value_as_int).to eq 13
  end
end