require 'page-object'

class Survey
  include PageObject

  page_url "bit.ly/watir-webdriver-demo"

  text_field(:name, :id => 'entry_1000000')
  select(:language, :id => 'entry_1000001')
  radio_button(:ruby_is, :id => 'group_1000003_1')
  button(:submit, :name => 'submit')
end

class SurveyResult
  include PageObject
  div(:response, :xpath => '//div[@class="ss-resp-message"]')
end