require 'rspec'
require_relative 'roman_numerals.rb'

describe 'roman_numeral_converter' do
    # single letters
    it 'turns a 1 into an I' do
        expect(roman_numeral_converter 1).to eq 'I'
    end
    it 'turns a 5 into an V' do
        expect(roman_numeral_converter 5).to eq 'V'
    end
    it 'turns a 10 into an X' do
        expect(roman_numeral_converter 10).to eq 'X'
    end
    it 'turns a 50 into an L' do
        expect(roman_numeral_converter 50).to eq 'L'
    end
    it 'turns a 100 into an C' do
        expect(roman_numeral_converter 100).to eq 'C'
    end
    it 'turns a 500 into an D' do
        expect(roman_numeral_converter 500).to eq 'D'
    end
    it 'turns a 1000 into an M' do
        expect(roman_numeral_converter 1000).to eq 'M'
    end
    # one each of multiple letters
    it 'turns a 15 into an XV' do
        expect(roman_numeral_converter 15).to eq 'XV'
    end
    it 'turns a 11 into an XI' do
        expect(roman_numeral_converter 11).to eq 'XI'
    end
    it 'turns a 6 into an VI' do
        expect(roman_numeral_converter 6).to eq 'VI'
    end
    it 'turns a 16 into an XVI' do
        expect(roman_numeral_converter 16).to eq 'XVI'
    end
    it 'turns a 165 into an CLXV' do
        expect(roman_numeral_converter 165).to eq 'CLXV'
    end
    it 'turns a 1650 into an MDCL' do
        expect(roman_numeral_converter 1650).to eq 'MDCL'
    end
    # multiple of the same letter
    it 'turns a 2 into an II' do
        expect(roman_numeral_converter 2).to eq 'II'
    end
    it 'turns a 3 into an III' do
        expect(roman_numeral_converter 3).to eq 'III'
    end
    it 'turns a 37 into an XXXVII' do
        expect(roman_numeral_converter 37).to eq 'XXXVII'
    end
    it 'turns a 333 into an CCCXXXIII' do
        expect(roman_numeral_converter 333).to eq 'CCCXXXIII'
    end
    it 'turns a 2800 into an MMDCCC' do
        expect(roman_numeral_converter 2800).to eq 'MMDCCC'
    end
    # inverted order for one less than a letter
    it 'turns a 9 into an IX' do
        expect(roman_numeral_converter 9).to eq 'IX'
    end
    it 'turns a 4 into an IV' do
        expect(roman_numeral_converter 4).to eq 'IV'
    end
    it 'turns a 29 into an XXIX' do
        expect(roman_numeral_converter 29).to eq 'XXIX'
    end
    it 'turns a 41 into an XLI' do
        expect(roman_numeral_converter 41).to eq 'XLI'
    end
    it 'turns a 99 into an XCIX' do
        expect(roman_numeral_converter 99).to eq 'XCIX'
    end
    it 'turns a 9044 into an CM' do
        expect(roman_numeral_converter 99).to eq 'XCIX'
    end
end