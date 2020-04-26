package com.nemanja.prvidomaci.model

import java.text.SimpleDateFormat
import java.util.*

class PatientFactory {

    companion object {
        const val unknownImage: String = "https://us.123rf.com/450wm/mialima/mialima1603/mialima160300025/55096766-stock-vector-male-user-icon-isolated-on-a-white-background-account-avatar-for-web-user-profile-picture-unknown-ma.jpg?ver=6"
        const val unknown: String = "Unknown"
        private val sdf = SimpleDateFormat("dd-MM-yyyy")
        val unknownDate: Date = sdf.parse("10-10-1980") ?: Date()
        val nameList: List<String> = listOf("Luka", "Stefan", "Lazar", "Vuk", "Filip", "Vukašin", "Viktor", "Andrej", "Pavle", "Vasilije", "Uroš", "Bogdan", "Aleksa", "Petar", "Nikola", "Mihajlo", "Ognjen", "Kosta", "Dušan", "Jovan", "Marko", "Strahinja", "Vukan", "Đorđe", "Aleksandar", "Dimitrije", "Andrija", "Relja", "Matija", "Mihailo", "Teodor", "Mateja", "Maksim", "David", "Jakov", "Nemanja", "Konstantin", "Sergej", "Aleksej", "Veljko", "Miloš", "Tadija", "Vojin", "Ilija", "Danilo", "Milan", "Damjan", "Sava", "Todor", "Arsenije", "Despot", "Vanja", "Ivan", "Jakša", "Janko", "Rastko", "Lav", "Vladimir", "Ignjat", "Novak", "Gavrilo", "Matej", "Nikša", "Vidak", "Stevan", "Vid", "Milutin", "Uglješa", "Boris", "Mijat", "Jasin", "Momčilo", "Aljoša", "Balša", "Dragan", "Emir", "Leon", "Martin", "Nikolaj", "Simon", "Adam", "Simeon", "Tadej", "Igor", "Zoran", "Branko", "Kristijan", "Nenad", "Boško", "Dejan", "Đurađ", "Slobodan", "Srđan", "Božidar", "Mateo", "Mladen", "Oleg", "Saša", "Vujadin", "Matea","Sofija", "Dunja", "Sara", "Teodora", "Lena", "Ana", "Mila", "Petra", "Tara", "Nina", "Milica", "Maša", "Helena", "Lenka", "Una", "Jana", "Nikolina", "Nađa", "Anastasija", "Anđela", "Anja", "Danica", "Iskra", "Emilija", "Mia", "Katarina", "Andrea", "Elena", "Natalija", "Staša", "Marija", "Hana", "Kalina", "Lana", "Jovana", "Anđelija", "Iva", "Magdalena", "Lara", "Kristina", "Mina", "Irina", "Minja", "Aleksandra", "Đurđa", "Ema", "Isidora", "Nika", "Srna", "Vanja", "Tamara", "Višnja", "Ljubica", "Nevena", "Darija", "Neda", "Ivona", "Anika", "Simona", "Vera", "Nikolija", "Jelena", "Tijana", "Julija", "Iris", "Marta", "Kasija", "Ksenija", "Viktorija", "Angelina", "Miona", "Sonja", "Andrijana", "Kruna", "Olga", "Valentina", "Zoja", "Eva", "Tea", "Lola", "Matea", "Nataša", "Ivana", "Mitra", "Nora", "Tatjana", "Dorotea", "Janja", "Leonora", "Ružica", "Sofia", "Vida", "Aleksija", "Irena", "Katja", "Martina", "Zara", "Drina", "Hristina", "Jelisaveta")
        val lastNameList: List<String> = listOf("Jovanović", "Petrović", "Nikolić", "Ilić", "Đorđević", "Pavlović", "Marković", "Popović", "Stojanović", "Živković", "Janković", "Todorović", "Stanković", "Ristić", "Kostić", "Milošević", "Cvetković", "Kovačević", "Dimitrijević", "Tomić", "Krstić", "Ivanović", "Lukić", "Filipović", "Savić", "Mitrović", "Lazić", "Petković", "Obradović", "Aleksić", "Radovanović", "Lazarević", "Vasić", "Milovanović", "Jović", "Stevanović", "Milenković", "Milosavljević", "Mladenović", "Živanović", "Simić", "Đurić", "Nedeljković", "Novaković", "Marinković", "Bogdanović", "Knežević", "Radosavljević", "Mihajlović", "Gajić", "Mitić", "Stefanović", "Blagojević", "Antić", "Vasiljević", "Jevtić", "Đokić", "Stojković", "Vuković", "Rakić", "Stanojević", "Pešić", "Tasić", "Milić", "Milanović", "Zdravković", "Grujić", "Babić", "Vučković", "Matić", "Perić", "Ćirić", "Paunović", "Marjanović", "Maksimović", "Anđelković", "Jakovljević", "Gavrilović", "Veljković", "Tošić", "Trajković", "Ivković", "Arsić", "Miletić", "Veličković", "Radović", "Miljković", "Nešić", "Jeremić", "Radulović", "Đurđević", "Milojević", "Urošević", "Bošković", "Trifunović", "Božić", "Radivojević", "Đukić", "Milutinović", "Stamenković")
        val symptoms: List<String> = listOf("Fever of 100.4 F (38 C) in newborns up to 12 weeks", "Rising fever or fever lasting more than two days in a child of any age", "Symptoms that worsen or fail to improve", "Severe symptoms, such as headache or cough", "Wheezing", "Ear pain", "Extreme fussiness", "Unusual drowsiness", "Lack of appetite", "Fever greater than 101.3 F (38.5 C)", "Fever lasting five days or more or returning after a fever-free period", "Shortness of breath", "Wheezing", "Severe sore throat, headache or sinus pain", "Runny or stuffy nose", "Sore throat", "Cough", "Congestion", "Slight body aches or a mild headache", "Sneezing", "Low-grade fever", "Generally feeling unwell (malaise)")
    }

    fun createPatient(pictureUrl: String? = unknownImage, name: String? = nameList[Random().nextInt(nameList.size)], lastName: String? = lastNameList[Random().nextInt(lastNameList.size)], hospital: String? = unknown, stateOnReception: String? = symptoms[Random().nextInt(symptoms.size)],
                      currentState: String? = unknown, inHospital: Boolean? = true, dateOfArrival: Date? = unknownDate, dateOfHospitalization: Date? = null, dateOfLeaving: Date? = null) : Patient {
        val stateOnReceptionTmp = stateOnReception ?: symptoms[Random().nextInt(symptoms.size)]
        return Patient(
            UUID.randomUUID(),
            pictureUrl ?: unknownImage,
            name ?: nameList[Random().nextInt(nameList.size)],
            lastName ?: lastNameList[Random().nextInt(lastNameList.size)],
            hospital ?: unknown,
            stateOnReceptionTmp,
            currentState ?: stateOnReceptionTmp,
            inHospital ?: true,
            dateOfArrival ?: unknownDate,
            dateOfHospitalization,
            dateOfLeaving
        )
    }

    fun getFirstDate(): Date {
        val sdf = SimpleDateFormat("dd-MM-yyyy")
        return sdf.parse("10-10-1980") ?: Date()
    }
}