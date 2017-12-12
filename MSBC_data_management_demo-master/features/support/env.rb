require 'watir'
require 'page-object'
require 'faker'
require 'factory_bot'
require_relative '../../lib/mock_survey_site'
require 'rspec'



Around do |scenario, block|
  begin
    thread = Thread.new { Rack::Handler::WEBrick.run MockSurvey, {Port: 4567} }
    sleep 1
    @browser = Watir::Browser.new :firefox
    block.call
  rescue => e
    puts e.message
    puts e.backtrace
  ensure
    @browser.close
    thread.kill
  end
end

World(PageObject::PageFactory)
World(FactoryBot::Syntax::Methods)
DataMagic.yml_directory = 'features/data'