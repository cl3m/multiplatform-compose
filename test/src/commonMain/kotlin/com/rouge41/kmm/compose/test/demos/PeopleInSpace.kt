package com.rouge41.kmm.compose.test.demos

import com.rouge41.kmm.compose.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.native.concurrent.ThreadLocal

@Composable
fun PeopleInSpace() {
    val peopleInSpaceViewModel = PeopleInSpaceViewModel()
    MainLayout(peopleInSpaceViewModel)
}

val maroon200 = Color(0xFFb73d2a)
val maroon500 = Color(0xFF800000)
val maroon700 = Color(0xFF4f0000)
val teal200 = Color(0xFF03DAC5)


val lowAvailabilityColor = Color(0xFFFF8C00)
val highAvailabilityColor = Color(0xFF008000)

private val DarkColorPalette = darkColors(
    primary = maroon200,
    primaryVariant = maroon700,
    secondary = teal200
)

private val LightColorPalette = lightColors(
    primary = maroon500,
    primaryVariant = maroon700,
    secondary = teal200
)

@Composable
fun PeopleInSpaceTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        content = content
    )
}

sealed class Screen(val title: String) {
    object PersonListScreen : Screen("PersonList")
    object PersonDetailsDetails : Screen("PersonDetails")
}

val personImages = mapOf(
    "Chris Cassidy" to "https://www.nasa.gov/sites/default/files/styles/side_image/public/thumbnails/image/9368855148_f79942efb7_o.jpg?itok=-w5yoryN",
    "Anatoly Ivanishin" to "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/Anatoli_Ivanishin_2011.jpg/440px-Anatoli_Ivanishin_2011.jpg",
    "Ivan Vagner" to "http://www.spacefacts.de/more/cosmonauts/photo/vagner_ivan_3.jpg",
    "Sergey Ryzhikov" to "https://spaceflight101.com/iss-expedition-50/wp-content/uploads/sites/118/2016/11/jsc2016e105228.jpg",
    "Kate Rubins" to "https://spaceflight101.com/iss-expedition-49/wp-content/uploads/sites/110/2016/09/26720141242_be992e9a20_o-768x1152.jpg",
    "Sergey Kud-Sverchkov" to "https://www.esa.int/var/esa/storage/images/esa_multimedia/images/2014/08/sergey_kud-sverchkov/14716838-1-eng-GB/Sergey_Kud-Sverchkov_pillars.jpg",
    "Mike Hopkins" to "https://pbs.twimg.com/media/Em5EbQOVEAAdZ0h?format=jpg&name=medium",
    "Victor Glover" to "https://pbs.twimg.com/media/Em5EbSnUYAEAgyl?format=jpg&name=medium",
    "Shannon Walker" to "https://pbs.twimg.com/media/Em5EbQPVoAATIx8?format=jpg&name=medium",
    "Soichi Noguchi" to "https://pbs.twimg.com/media/Em5EbSoVcAA3R2F?format=jpg&name=medium"
)

val personBios = mapOf(
    "Chris Cassidy" to "Christopher John \"Chris\" Cassidy (born January 4, 1970, in Salem, Massachusetts) is a NASA astronaut and United States Navy SEAL. Chris Cassidy achieved the rank of captain in the U.S. Navy. He was the Chief of the Astronaut Office at NASA from July 2015 until June 2017.",
    "Anatoly Ivanishin" to "Anatoli Alekseyevich Ivanishin (Russian: Анатолий Алексеевич Иванишин; born 15 January 1969) is a Russian cosmonaut. His first visit to space was to the International Space Station on board the Soyuz TMA-22 spacecraft as an Expedition 29 / Expedition 30 crew member, launching in November 2011 and returning in April 2012. Ivanishin was the Commander of the International Space Station for Expedition 49.",
    "Ivan Vagner" to "Ivan Viktorovich Vagner (born 10 July 1985) is a Russian engineer and cosmonaut who was selected in October 2010. He graduated from the Baltic State Technical University in 2008, before working as an engineer for RKK Energia.\n\nHe began his first spaceflight in April 2020 as a Flight Engineer on Soyuz MS-16 and Expedition 62/63.",
    "Sergey Ryzhikov" to "Sergey Nikolayevich Ryzhikov (Russian: Сергей Николаевич Рыжиков; born on August 19, 1974), lieutenant colonel of Russian Air Force, is a Russian cosmonaut, selected in 2006. Ryzhikov launched on his first spaceflight on board the Soyuz MS-02 spacecraft. He spent approximately six months on board the International Space Station taking part in Expedition 49/50, returning to Earth on April 10, 2017",
    "Kate Rubins" to "Kathleen Hallisey \"Kate\" Rubins (born October 14, 1978) is a NASA astronaut. She became the 60th woman to fly in space when she launched on a Soyuz spacecraft to the International Space Station on July 7, 2016. She returned to Earth on October 30, 2016 aboard a Soyuz.[3] She was a crew member of Expedition 48 and Expedition 49 of the International Space Station.",
    "Sergey Kud-Sverchkov" to "Sergey Vladimirovich Kud-Sverchkov was born on August 23, 1983 at the Baikonur Cosmodrome in the Kazakh Soviet Socialist Republic. Sergey Kud-Sverchkov is married and father of one daughter. Since April 2010, he is a Russian Cosmonaut of the Russian Space Agency Roscosmos. He is currently in space.",
    "Mike Hopkins" to "Michael Scott Hopkins was born on December 28, 1968 in Lebanon, Missouri but grew up on a farm in Richland, Missouri in a United Methodist family. After graduating from the School of the Osage High School in Lake of the Ozarks, Missouri, in 1987, he entered the University of Illinois at Urbana-Champaign. While there, he played defensive back for the Illinois Fighting Illini football team. He graduated in 1991 with a Bachelor of Science degree in aerospace engineering. He followed his undergraduate studies with a Master of Science degree in aerospace engineering from Stanford University, which he earned in 1992.",
    "Victor Glover" to "Victor Jerome Glover (born April 30, 1976) is a NASA astronaut of the class of 2013 and Pilot on the first operational flight of the SpaceX Crew Dragon to the International Space Station. Glover is a commander in the U.S. Navy where he pilots an F/A-18, and a graduate of the U.S. Air Force Test Pilot School.",
    "Shannon Walker" to "Shannon Walker (born 4 June 1965 in Houston, Texas) is an American physicist and a NASA astronaut selected in 2004. She launched on her first mission into space on 25 June 2010 onboard Soyuz TMA-19 and spent over 163 days in space.\n\nShe returned to space for her second long duration mission on 15 November 2020, onboard SpaceX Crew-1, the first operational flight of SpaceX's Crew Dragon spacecraft.",
    "Soichi Noguchi" to "Soichi Noguchi (野口 聡一, Noguchi Sōichi, born 15 April 1965 in Yokohama, Japan) is a Japanese aeronautical engineer and JAXA astronaut. His first spaceflight was as a Mission Specialist aboard STS-114 on 26 July 2005 for NASA's first \"return to flight\" Space Shuttle mission after the Columbia disaster. He was also in space as part of the Soyuz TMA-17 crew and Expedition 22 to the International Space Station (ISS), returning to Earth on 2 June 2010. He is the fifth Japanese astronaut to fly in space and the fourth to fly on the space shuttle. His third flight is onboard the Dragon 2 capsule for the SpaceX Crew-1 mission which launched successfully on November 15, 2020. This makes him one of only three astronauts to fly on three different launch systems."
)

data class Assignment(val name: String, val craft: String)

data class IssPosition(val latitude: Double, val longitude: Double)

class PeopleInSpaceViewModel() {

    val peopleInSpace = MutableStateFlow(listOf<Assignment>(Assignment("Soichi Noguchi", "Craft"), Assignment("Mike Hopkins", "Craft"), Assignment("Anatoly Ivanishin", "Craft"))).asStateFlow()
    val issPosition = MutableStateFlow(IssPosition(40.0, 10.0)).asStateFlow()

    fun getPersonBio(personName: String): String {
        return personBios[personName] ?: ""
    }

    fun getPersonImage(personName: String): String {
        return personImages[personName] ?: ""
    }

    fun getPerson(personName: String): Assignment? {
        return peopleInSpace.value.find { it.name == personName}
    }
}

@Composable
fun MainLayout(peopleInSpaceViewModel: PeopleInSpaceViewModel) {
    val navController = rememberNavController()

    PeopleInSpaceTheme {
        NavHost(navController, startDestination = Screen.PersonListScreen.title) {
            composable(Screen.PersonListScreen.title, title = "People In Space") {
                PersonList(peopleInSpaceViewModel = peopleInSpaceViewModel,
                    personSelected = {
                        navController.navigate(Screen.PersonDetailsDetails.title + "/${it.name}")
                    }
                )
            }
            composable(Screen.PersonDetailsDetails.title + "/{person}", title = "{person}") { backStackEntry ->
                PersonDetailsView(peopleInSpaceViewModel,
                    backStackEntry.getArguments()?.get("person") as String,
                    popBack = {
                        navController.popBackStack()
                    })
            }
        }
    }
}

@Composable
fun PersonList(peopleInSpaceViewModel: PeopleInSpaceViewModel, personSelected : (person : Assignment) -> Unit) {
    val peopleState = peopleInSpaceViewModel.peopleInSpace
    val issPosition = peopleInSpaceViewModel.issPosition

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("People In Space") })
        },
        bodyContent = {
            LazyColumn {
                item {
                    ISSPosition(issPosition.value)
                    Divider(thickness = 2.dp)
                }
                items(peopleState.value) {  person ->
                    val personImageUrl = peopleInSpaceViewModel.getPersonImage(person.name)
                    PersonView(personImageUrl, person, personSelected)
                }
            }
        }
    )
}

@Composable
fun ISSPosition(issPosition: IssPosition) {
    Text(text = "ISS Position = (${issPosition.latitude}, ${issPosition.longitude})",
        Modifier.padding(16.dp).fillMaxWidth(),
        textAlign = TextAlign.Center,
        style = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            letterSpacing = 0.15.sp
        )
    )

}



@Composable
fun PersonView(personImageUrl: String, person: Assignment, personSelected : (person : Assignment) -> Unit) {
    Row(
        modifier =  Modifier.fillMaxWidth().clickable(onClick = { personSelected(person) })
            .padding(16.dp), verticalAlignment = Alignment.CenterVertically
    ) {

        if (personImageUrl.isNotEmpty()) {
            Image(url = personImageUrl, modifier = Modifier.preferredSize(60.dp))
        } else {
            Spacer(modifier = Modifier.preferredSize(60.dp))
        }

        Spacer(modifier = Modifier.preferredSize(12.dp))

        Column {
            Text(text = person.name, style = TextStyle(fontSize = 20.sp))
            Text(text = person.craft, style = TextStyle(color = Color.DarkGray, fontSize = 14.sp))
        }
    }
}

@Composable
fun PersonDetailsView(peopleInSpaceViewModel: PeopleInSpaceViewModel, personName: String, popBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(personName) },
                navigationIcon = {
                    Button(onClick = { popBack() }) {
                        Icon(iconArrowBack())
                    }
                }
            )
        },
        bodyContent = {
            ScrollableColumn(modifier = Modifier.padding(16.dp).fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                    val person = peopleInSpaceViewModel.getPerson(personName)
                    person?.let {
                        Text(person.name, style = TextStyle(fontSize = 25.sp))
                        Spacer(modifier = Modifier.preferredSize(12.dp))

                        val imageUrl = peopleInSpaceViewModel.getPersonImage(person.name)
                        if (imageUrl.isNotEmpty()) {
                            Image(url = imageUrl, modifier = Modifier.preferredSize(240.dp))
                        }
                        Spacer(modifier = Modifier.preferredSize(24.dp))

                        val bio = peopleInSpaceViewModel.getPersonBio(person.name)
                        Text(bio)
                    }
            }
        }
    )
}
