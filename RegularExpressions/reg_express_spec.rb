require 'rspec'
require_relative 'reg_express.rb'

describe 'dog_express' do
    it 'should return 0 for string without name' do
        expect(dog_express "My dog\'s name is \"\"").to eq 0
    end
    it 'should return 0 for string with any name' do
        expect(dog_express "My dog\'s name is \"Rocky\"").to eq 0
    end
    it 'should return nil for starting with anything else' do
        expect(dog_express "Hello! My dog\'s name is \"Rocky\"").to eq nil
    end
end

describe 'phone_express' do
    it 'should return 0 for xxx-xxx-xxxx' do
        expect(phone_express "555-555-5555").to eq 0
    end
    it 'should return 0 for xxx xxx xxxx' do
        expect(phone_express "555 555 5555").to eq 0
    end
    it 'should return 0 for 911' do
        expect(phone_express "911").to eq 0
    end
    it 'should return 0 for 411' do
        expect(phone_express "411").to eq 0
    end
    it 'should return nil for xx-xx-xxx' do
        expect(phone_express "11-22-444").to eq nil
    end
    it 'should return nil for (xxx)xxx xxxx' do
        expect(phone_express "(111)222 5555").to eq nil
    end
    it 'should return nil for xxxxxxxxxx' do
        expect(phone_express "1234567890").to eq nil
    end
    it 'should return nil for xxxx-xxxx-xxxxx' do
        expect(phone_express "2222-3333-55555").to eq nil
    end
    it 'should return nil for xxx' do
        expect(phone_express "811").to eq nil
    end
    it 'should return nil for xxxx-xxxx xxxxx' do
        expect(phone_express "111-222 3333").to eq nil
    end
end