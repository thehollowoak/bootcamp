require 'sinatra'
require 'webrick'
require 'webrick/https'
require 'openssl'

class MockSurvey < Sinatra::Base
  get '/' do
    content_type :html
    File.open('lib/index.html')
  end

end