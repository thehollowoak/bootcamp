require_relative '../../calc.rb'

Given(/^I enter (-?\d+) and (-?\d+)$/) do |a, b|
  @calc = Calculator.new
  @calc.num1 = a
  @calc.num2 = b
end

When(/^I add the numbers$/) do
  @result = @calc.perform_add
end

Then(/^the result should be (-?\d+)$/) do |expected|
  expect(@result).to eq expected
end

When(/^I subtract the numbers$/) do
  @result = @calc.perform_subtract
end

When(/^I multiply the numbers$/) do
  @result = @calc.perform_multiply
end

When(/^I divide the numbers$/) do
  @result = @calc.perform_divide
end