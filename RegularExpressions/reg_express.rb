
def dog_express(string)
    string =~ /^My dog's name is ".*"/
end

def phone_express(string)
    string =~ /(\d{3}(\-| )\d{3}\2\d{4})|911|411/
end