require 'page-object'
include PageObject::PageFactory

Given(/^I visit the platform registration system$/) do
  visit_page Survey
end

When(/^I submit my information$/) do
  on_page Survey do |page|
    page.name = 'your name'
    page.language = 'Ruby'
    page.select_ruby_is
    page.submit
  end
  #sleep 2
end

Then(/^I get a big thanks$/) do
  on_page SurveyResult do |page|
    expect(page.response).to include 'Thank you'
  end
end