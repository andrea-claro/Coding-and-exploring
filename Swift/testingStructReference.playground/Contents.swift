struct Town {
    var population = 1234

    mutating func updatePopulation(newPopulation: Int) {
        print("\n\n\nUpdating population to \(newPopulation)")
        population = newPopulation
        print("Population has been updated to \(population)")
    }

    func describeTown() {
        print("\nthe town now has population of \(population)")
    }
}

class Test{
    var city: Town?
    
    init(city: inout Town){
        self.city = city
    }
    
    func update(){
        self.city?.updatePopulation(newPopulation: 20)
    }
}

var orangeCounty = Town()
orangeCounty.updatePopulation(newPopulation: 100)
orangeCounty.describeTown()

var yorkCountry = orangeCounty
yorkCountry.updatePopulation(newPopulation: 50)
yorkCountry.describeTown()

orangeCounty.describeTown()

var test = Test(city: &orangeCounty)
test.update()

orangeCounty.describeTown()

