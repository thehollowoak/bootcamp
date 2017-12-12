class SurveyPage
  include PageObject

  page_url 'http://localhost:4567'

  text_field(:name, :id => 'name')
end