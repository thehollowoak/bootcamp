
include PageObject::PageFactory

Given(/^I have a fake name$/) do
  @name = Faker::Name.name
end

When(/^I fill in the name$/) do
  visit SurveyPage do |page|
    page.name = @name
  end
end

Then(/^the name is populated$/) do
  on_page SurveyPage do |page|
    expect(page.name).not_to be_empty
  end
end