package com.github.pedrovgs.effectiveandroidui.domain.tvshow;

import com.github.pedrovgs.effectiveandroidui.domain.exception.TvShowNotFoundException;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Contains all the available TvShows.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class Catalog {

  private final LinkedHashSet<TvShow> tvShows;

  /**
   * Default constructor. All this hardcoded information is going to be used as mocked information
   * for the demo application.
   */
  public Catalog() {
    this.tvShows = new LinkedHashSet<TvShow>();
    TvShow tvShow =
        new TvShow("Breaking Bad", "http://thetvdb.com/banners/_cache/posters/81189-22.jpg",
            "http://thetvdb.com/banners/_cache/fanart/original/81189-21.jpg", 5);
    tvShow.addEpisode(new Chapter("Pilot", "2008-01-20"));
    tvShow.addEpisode(new Chapter("Cat's in the Bag...", "2008-01-27"));
    tvShow.addEpisode(new Chapter("...And the Bag's in the River", "2008-02-10"));
    tvShow.addEpisode(new Chapter("Cancer Man", "2008-02-17"));
    tvShow.addEpisode(new Chapter("Gray Matter", "2008-02-24"));
    tvShow.addEpisode(new Chapter("Crazy Handful of Nothin'", "2008-03-02"));
    tvShow.addEpisode(new Chapter("A No-Rough-Stuff-Type Deal'", "2008-03-09"));
    tvShows.add(tvShow);

    tvShow = new TvShow("Marvel's Agents of S.H.I.E.L.D.",
        "http://thetvdb.com/banners/_cache/posters/263365-3.jpg",
        "http://thetvdb.com/banners/_cache/fanart/original/263365-4.jpg", 1);
    tvShow.addEpisode(new Chapter("Pilot", "2013-09-24"));
    tvShow.addEpisode(new Chapter("0-8-4", "2013-10-01"));
    tvShow.addEpisode(new Chapter("The Asset", "2013-10-08"));
    tvShow.addEpisode(new Chapter("Eye Spy", "2013-10-15"));
    tvShow.addEpisode(new Chapter("Girl in the Flower Dress", "2013-10-22"));
    tvShow.addEpisode(new Chapter("F.Z.Z.T.", "2013-11-05"));
    tvShow.addEpisode(new Chapter("The Hub", "2013-11-12"));
    tvShow.addEpisode(new Chapter("The Well", "2013-11-19"));
    tvShow.addEpisode(new Chapter("Repairs", "2013-11-26"));
    tvShow.addEpisode(new Chapter("The Bridge", "2013-12-10"));
    tvShow.addEpisode(new Chapter("The Magical Place", "2014-01-07"));
    tvShow.addEpisode(new Chapter("Seeds", "2014-01-14"));
    tvShow.addEpisode(new Chapter("T.R.A.C.K.S.", "2014-02-04"));
    tvShow.addEpisode(new Chapter("T.A.H.I.T.I.", "2014-03-04"));
    tvShow.addEpisode(new Chapter("Yes Men", "2014-03-11"));
    tvShow.addEpisode(new Chapter("End of the Beginning", "2014-04-01"));
    tvShow.addEpisode(new Chapter("Turn, Turn, Turn", "2014-04-08"));
    tvShow.addEpisode(new Chapter("Providence", "2014-04-15"));
    tvShows.add(tvShow);

    tvShow = new TvShow("Lost", "http://thetvdb.com/banners/_cache/posters/73739-7.jpg",
        "http://thetvdb.com/banners/_cache/fanart/original/73739-20.jpg", 6);
    tvShow.addEpisode(new Chapter("Pilot (1)", "2004-09-22"));
    tvShow.addEpisode(new Chapter("Pilot (2)", "2004-09-29"));
    tvShow.addEpisode(new Chapter("Tabula Rasa", "2004-10-06"));
    tvShow.addEpisode(new Chapter("Walkabout", "2004-10-13"));
    tvShow.addEpisode(new Chapter("White Rabbit", "2004-10-20"));
    tvShow.addEpisode(new Chapter("House of the Rising Sun", "2004-10-27"));
    tvShow.addEpisode(new Chapter("The Moth", "2004-11-03"));
    tvShow.addEpisode(new Chapter("Confidence Man", "2004-11-10"));
    tvShow.addEpisode(new Chapter("Solitary", "2004-11-17"));
    tvShow.addEpisode(new Chapter("Raised by Another", "2004-12-01"));
    tvShow.addEpisode(new Chapter("All the Best Cowboys Have Daddy Issues", "2004-12-08"));
    tvShow.addEpisode(new Chapter("Whatever the Case May Be the Case May Be", "2005-01-05"));
    tvShow.addEpisode(new Chapter("Hearts and Minds", "2005-01-12"));
    tvShow.addEpisode(new Chapter("Special", "2005-01-19"));
    tvShow.addEpisode(new Chapter("Homecoming", "2005-02-09"));
    tvShow.addEpisode(new Chapter("Outlaws", "2005-02-16"));
    tvShow.addEpisode(new Chapter("...In Translation", "2005-02-23"));
    tvShow.addEpisode(new Chapter("Numbers", "2005-03-02"));
    tvShow.addEpisode(new Chapter("Deus Ex Machina", "2005-03-30"));
    tvShow.addEpisode(new Chapter("Do No Harm", "2005-04-06"));
    tvShow.addEpisode(new Chapter("The Greater Good (a.k.a. Sides)", "2005-05-04"));
    tvShow.addEpisode(new Chapter("Born to Run", "2005-05-11"));
    tvShow.addEpisode(new Chapter("Exodus (1)", "2005-05-18"));
    tvShow.addEpisode(new Chapter("Exodus (2)", "2005-05-25"));
    tvShows.add(tvShow);

    tvShow = new TvShow("Arrow", "http://thetvdb.com/banners/_cache/posters/257655-5.jpg",
        "http://thetvdb.com/banners/_cache/fanart/original/257655-16.jpg", 2);
    tvShow.addEpisode(new Chapter("Pilot", "2012-10-10"));
    tvShow.addEpisode(new Chapter("Honor Thy Father", "2012-10-17"));
    tvShow.addEpisode(new Chapter("Lone Gunmen", "2012-10-24"));
    tvShow.addEpisode(new Chapter("An Innocent Man", "2012-10-31"));
    tvShow.addEpisode(new Chapter("Damaged", "2012-11-07"));
    tvShow.addEpisode(new Chapter("Legacies", "b2012-11-14"));
    tvShow.addEpisode(new Chapter("Muse of Fire", "2012-11-28"));
    tvShow.addEpisode(new Chapter("Vendetta", "2012-12-05"));
    tvShow.addEpisode(new Chapter("Year's End", "2012-12-12"));
    tvShow.addEpisode(new Chapter("Burned", "2013-01-16"));
    tvShow.addEpisode(new Chapter("Trust But Verify", "2013-01-23"));
    tvShow.addEpisode(new Chapter("Vertigo", "2013-02-06"));
    tvShow.addEpisode(new Chapter("Betrayal", "2013-02-06"));
    tvShow.addEpisode(new Chapter("The Odyssey", "2013-02-13"));
    tvShow.addEpisode(new Chapter("Dodger", "2013-02-20"));
    tvShow.addEpisode(new Chapter("Dead to Rights", "2013-02-27"));
    tvShow.addEpisode(new Chapter("The Huntress Returns", "2013-03-20"));
    tvShow.addEpisode(new Chapter("Salvation", "2013-03-27"));
    tvShow.addEpisode(new Chapter("Unfinished Business", "2013-04-03"));
    tvShow.addEpisode(new Chapter("Home Invasion", "2013-04-24"));
    tvShow.addEpisode(new Chapter("The Undertaking", "2013-05-01"));
    tvShow.addEpisode(new Chapter("Darkness on the Edge of Town", "2013-05-08"));
    tvShow.addEpisode(new Chapter("Sacrifice", "2013-05-15"));
    tvShows.add(tvShow);

    tvShow = new TvShow("The Newsroom", "http://thetvdb.com/banners/_cache/posters/76399-1.jpg",
        "http://thetvdb.com/banners/_cache/fanart/original/76399-1.jpg", 3);
    tvShow.addEpisode(new Chapter("The Walking Shoe Incident", "1996-10-21"));
    tvShow.addEpisode(new Chapter("Dinner at Eight", "1996-10-28"));
    tvShow.addEpisode(new Chapter("Deeper, Deeper", "1996-11-04-11-04"));
    tvShow.addEpisode(new Chapter("The Kevorkian Joke", "1996-11-11"));
    tvShow.addEpisode(new Chapter("A Bad Day", "1996-11-18"));
    tvShow.addEpisode(new Chapter("Petty Tyranny", "1996-11-25"));
    tvShow.addEpisode(new Chapter("Dis and Dat", "1997-02-10"));
    tvShow.addEpisode(new Chapter("Unity", "1997-02-17"));
    tvShow.addEpisode(new Chapter("Parking", "1997-02-24"));
    tvShow.addEpisode(new Chapter("Meltdown (1)", "1997-03-03"));
    tvShow.addEpisode(new Chapter("Meltdown (2)", "1997-03-17"));
    tvShow.addEpisode(new Chapter("Meltdown (3)", "1997-03-24"));
    tvShow.addEpisode(new Chapter("The Campaign", "1997-03-31"));
    tvShows.add(tvShow);

    tvShow = new TvShow("How I Met Your Mother",
        "http://thetvdb.com/banners/_cache/posters/75760-29.jpg",
        "http://thetvdb.com/banners/_cache/fanart/original/75760-51.jpg", 9);
    tvShow.addEpisode(new Chapter("Pilot", "2005-09-19"));
    tvShow.addEpisode(new Chapter("Purple Giraffe", "2005-09-26"));
    tvShow.addEpisode(new Chapter("Sweet Taste of Liberty", "2005-10-03"));
    tvShow.addEpisode(new Chapter("Return of the Shirt", "2005-10-10"));
    tvShow.addEpisode(new Chapter("Okay Awesome", "2005-10-17"));
    tvShow.addEpisode(new Chapter("Slutty Pumpkin", "2005-10-24"));
    tvShow.addEpisode(new Chapter("Matchmaker", "2005-11-07"));
    tvShow.addEpisode(new Chapter("The Duel", "2005-11-14"));
    tvShow.addEpisode(new Chapter("Belly Full of Turkey", "2005-11-21"));
    tvShow.addEpisode(new Chapter("The Pineapple Incident", "2005-11-28"));
    tvShow.addEpisode(new Chapter("The Limo", "2005-12-19"));
    tvShow.addEpisode(new Chapter("The Wedding", "2006-01-09"));
    tvShow.addEpisode(new Chapter("Drumroll, Please", "2006-01-23"));
    tvShow.addEpisode(new Chapter("Zip, Zip, Zip", "2006-02-27"));
    tvShow.addEpisode(new Chapter("Game Night", "2006-02-06"));
    tvShow.addEpisode(new Chapter("Cupcake", "2006-03-06"));
    tvShow.addEpisode(new Chapter("Life Among the Gorillas", "2006-03-20"));
    tvShow.addEpisode(new Chapter("Nothing Good Happens After 2 A.M.", "2006-04-10"));
    tvShow.addEpisode(new Chapter("Mary the Paralegal", "2006-04-24"));
    tvShow.addEpisode(new Chapter("Best Prom Ever", "2006-05-01"));
    tvShow.addEpisode(new Chapter("Milk", "2006-05-08"));
    tvShow.addEpisode(new Chapter("Come On", "2006-05-15"));
    tvShows.add(tvShow);

    tvShow = new TvShow("Game of Thrones", "http://thetvdb.com/banners/_cache/posters/121361-4.jpg",
        "http://thetvdb.com/banners/_cache/fanart/original/121361-15.jpg", 4);
    tvShow.addEpisode(new Chapter("Winter Is Coming", "2011-04-17"));
    tvShow.addEpisode(new Chapter("The Kingsroad", "2011-04-24"));
    tvShow.addEpisode(new Chapter("Lord Snow", "2011-05-01"));
    tvShow.addEpisode(new Chapter("Cripples, Bastards, and Broken Things", "2011-05-08"));
    tvShow.addEpisode(new Chapter("The Wolf and the Lion", "2011-05-15"));
    tvShow.addEpisode(new Chapter("A Golden Crown", "2011-05-22"));
    tvShow.addEpisode(new Chapter("You Win or You Die", "2011-05-29"));
    tvShow.addEpisode(new Chapter("The Pointy End", "2011-06-05"));
    tvShow.addEpisode(new Chapter("Baelor", "2011-06-12"));
    tvShow.addEpisode(new Chapter("Fire and Blood", "2011-06-19"));
    tvShows.add(tvShow);

    tvShow = new TvShow("Dexter", "http://thetvdb.com/banners/_cache/posters/79349-24.jpg",
        "http://thetvdb.com/banners/_cache/fanart/original/79349-42.jpg", 8);
    tvShow.addEpisode(new Chapter("Dexter", "2006-10-01"));
    tvShow.addEpisode(new Chapter("Crocodile", "2006-10-08"));
    tvShow.addEpisode(new Chapter("Popping Cherry", "2006-10-15"));
    tvShow.addEpisode(new Chapter("Let's Give the Boy a Hand", "2006-10-22"));
    tvShow.addEpisode(new Chapter("Love American Style", "2006-10-29"));
    tvShow.addEpisode(new Chapter("Return to Sender", "2006-11-05"));
    tvShow.addEpisode(new Chapter("Circle of Friends", "2006-11-12"));
    tvShow.addEpisode(new Chapter("Shrink Wrap", "2006-11-19"));
    tvShow.addEpisode(new Chapter("Father Knows Best", "2006-11-26"));
    tvShow.addEpisode(new Chapter("Seeing Red", "2006-12-03"));
    tvShow.addEpisode(new Chapter("Truth Be Told", "2006-12-10"));
    tvShow.addEpisode(new Chapter("Born Free", "2006-12-17"));
    tvShows.add(tvShow);

    tvShow = new TvShow("House of Cards", "http://thetvdb.com/banners/_cache/posters/79861-1.jpg",
        "http://thetvdb.com/banners/_cache/fanart/original/79861-3.jpg", 3);
    tvShow.addEpisode(new Chapter("House of Cards Episode 1", "1990-11-18"));
    tvShow.addEpisode(new Chapter("House of Cards Episode 2", "1990-11-25"));
    tvShow.addEpisode(new Chapter("House of Cards Episode 3", "1990-12-02"));
    tvShow.addEpisode(new Chapter("House of Cards Episode 4", "1990-12-09"));
    tvShows.add(tvShow);

    tvShow =
        new TvShow("The Big Bang Theory", "http://thetvdb.com/banners/_cache/posters/80379-18.jpg",
            "http://thetvdb.com/banners/_cache/fanart/original/80379-38.jpg", 7);
    tvShow.addEpisode(new Chapter("Pilot", "2007-09-24"));
    tvShow.addEpisode(new Chapter("The Big Bran Hypothesis", "2007-10-01"));
    tvShow.addEpisode(new Chapter("The Fuzzy Boots Corollary", "2007-10-08"));
    tvShow.addEpisode(new Chapter("The Luminous Fish Effect", "2007-10-15"));
    tvShow.addEpisode(new Chapter("The Hamburger Postulate", "2007-10-22"));
    tvShow.addEpisode(new Chapter("The Middle Earth Paradigm", "2007-10-29"));
    tvShow.addEpisode(new Chapter("The Dumpling Paradox", "2007-11-05"));
    tvShow.addEpisode(new Chapter("The Grasshopper Experiment", "2007-11-12"));
    tvShow.addEpisode(new Chapter("The Cooper-Hofstadter Polarization", "2008-03-17"));
    tvShow.addEpisode(new Chapter("The Loobenfeld Decay", "2008-03-24"));
    tvShow.addEpisode(new Chapter("The Pancake Batter Anomaly", "2008-03-31"));
    tvShow.addEpisode(new Chapter("The Jerusalem Duality", "2008-04-14"));
    tvShow.addEpisode(new Chapter("The Bat Jar Conjecture", "2008-04-21"));
    tvShow.addEpisode(new Chapter("The Nerdvana Annihilation", "2008-04-28"));
    tvShow.addEpisode(new Chapter("The Pork Chop Indeterminacy", "2008-05-05"));
    tvShow.addEpisode(new Chapter("The Peanut Reaction", "2008-05-12"));
    tvShow.addEpisode(new Chapter("The Tangerine Factor", "2008-05-19"));
    tvShows.add(tvShow);

    tvShow = new TvShow("Sleepy Hollow", "http://thetvdb.com/banners/_cache/posters/269578-4.jpg",
        "http://thetvdb.com/banners/_cache/fanart/original/269578-4.jpg", 1);
    tvShow.addEpisode(new Chapter("Pilot", "2013-09-16"));
    tvShow.addEpisode(new Chapter("Blood Moon", "2013-09-23"));
    tvShow.addEpisode(new Chapter("For the Triumph of Evil", "2013-09-30"));
    tvShow.addEpisode(new Chapter("The Lesser Key of Solomon", "2013-10-07"));
    tvShow.addEpisode(new Chapter("John Doe", "2013-10-14"));
    tvShow.addEpisode(new Chapter("The Sin Eater", "2013-11-04"));
    tvShow.addEpisode(new Chapter("The Midnight Ride", "2013-11-11"));
    tvShow.addEpisode(new Chapter("Necromancer", "2013-11-18"));
    tvShow.addEpisode(new Chapter("Sanctuary", "2013-11-25"));
    tvShow.addEpisode(new Chapter("The Golem", "2013-12-09"));
    tvShow.addEpisode(new Chapter("The Vessel", "2014-01-13"));
    tvShow.addEpisode(new Chapter("Indispensable Man", "2014-01-20"));
    tvShow.addEpisode(new Chapter("Bad Blood", "2014-01-20"));
    tvShows.add(tvShow);

    tvShow =
        new TvShow("The Vampire Diaries", "http://thetvdb.com/banners/_cache/posters/95491-28.jpg",
            "http://thetvdb.com/banners/_cache/fanart/original/95491-68.jpg", 5);
    tvShow.addEpisode(new Chapter("Pilot", "2009-09-10"));
    tvShow.addEpisode(new Chapter("The Night of the Comet", "2009-09-17"));
    tvShow.addEpisode(new Chapter("Friday Night Bites", "2009-09-24"));
    tvShow.addEpisode(new Chapter("Family Ties", "2009-10-01"));
    tvShow.addEpisode(new Chapter("You're Undead to Me", "2009-10-08"));
    tvShow.addEpisode(new Chapter("Lost Girls", "2009-10-15"));
    tvShow.addEpisode(new Chapter("Haunted", "2009-10-29"));
    tvShow.addEpisode(new Chapter("162 Candles", "2009-11-05"));
    tvShow.addEpisode(new Chapter("History Repeating", "2009-11-12"));
    tvShow.addEpisode(new Chapter("The Turning Point", "2009-11-19"));
    tvShows.add(tvShow);

    tvShow = new TvShow("Friends", "http://thetvdb.com/banners/_cache/posters/79168-3.jpg",
        "http://thetvdb.com/banners/_cache/fanart/original/79168-6.jpg", 10);
    tvShow.addEpisode(new Chapter("The One Where Monica Gets A Roommate", "1994-09-22"));
    tvShow.addEpisode(new Chapter("The One With The Sonogram At The End", "1994-09-29"));
    tvShow.addEpisode(new Chapter("The One With The Thumb", "1994-10-06"));
    tvShow.addEpisode(new Chapter("The One With George Stephanopoulos", "1994-10-13"));
    tvShow.addEpisode(new Chapter("The One With The East German Laundry Detergent", "1994-10-20"));
    tvShow.addEpisode(new Chapter("The One With The Butt", "1994-10-27"));
    tvShow.addEpisode(new Chapter("The One With The Blackout", "1994-11-03"));
    tvShow.addEpisode(new Chapter("The One Where Nana Dies Twice", "1994-11-10"));
    tvShow.addEpisode(new Chapter("The One Where Underdog Gets Away", "1994-11-17"));
    tvShow.addEpisode(new Chapter("The One With The Monkey", "1994-12-15"));
    tvShows.add(tvShow);

    tvShow = new TvShow("New Girl", "http://thetvdb.com/banners/_cache/posters/248682-9.jpg",
        "http://thetvdb.com/banners/_cache/fanart/original/248682-20.jpg", 3);
    tvShow.addEpisode(new Chapter("Pilot", "2011-09-20"));
    tvShow.addEpisode(new Chapter("Kryptonite", "2011-09-27"));
    tvShow.addEpisode(new Chapter("Wedding", "2011-10-04"));
    tvShow.addEpisode(new Chapter("Naked", "2011-11-01"));
    tvShow.addEpisode(new Chapter("Cece Crashes", "2011-11-08"));
    tvShow.addEpisode(new Chapter("Thanksgiving", "2011-11-15"));
    tvShow.addEpisode(new Chapter("Bells", "2011-11-29"));
    tvShow.addEpisode(new Chapter("Bad in Bed", "2011-12-06"));
    tvShow.addEpisode(new Chapter("The 23rd", "2011-12-13"));
    tvShow.addEpisode(new Chapter("The Story of the 50", "2012-01-17"));
    tvShows.add(tvShow);

    tvShow = new TvShow("Family Guy", "http://thetvdb.com/banners/_cache/posters/75978-13.jpg",
        "http://thetvdb.com/banners/_cache/fanart/original/75978-27.jpg", 12);
    tvShow.addEpisode(new Chapter("Death has a Shadow", "1999-01-31"));
    tvShow.addEpisode(new Chapter("I Never Met the Dead Man", "1999-04-11"));
    tvShow.addEpisode(new Chapter("Chitty Chitty Death Bang", "1999-04-18"));
    tvShow.addEpisode(new Chapter("Mind Over Murder", "1999-04-25"));
    tvShow.addEpisode(new Chapter("A Hero Sits Next Door", "1999-05-02"));
    tvShow.addEpisode(new Chapter("The Son Also Draws", "1999-05-09"));
    tvShow.addEpisode(new Chapter("Brian: Portrait of a Dog", "1999-05-16"));
    tvShows.add(tvShow);

    tvShow = new TvShow("Gossip Girl", "http://thetvdb.com/banners/_cache/posters/80547-11.jpg",
        "http://thetvdb.com/banners/_cache/fanart/original/80547-24.jpg", 6);
    tvShow.addEpisode(new Chapter("Pilot", "2007-09-19"));
    tvShow.addEpisode(new Chapter("The Wild Brunch", "2007-09-26"));
    tvShow.addEpisode(new Chapter("Poison Ivy", "2007-10-03"));
    tvShow.addEpisode(new Chapter("Bad News Blair", "2007-10-10"));
    tvShow.addEpisode(new Chapter("Dare Devil", "2007-10-17"));
    tvShow.addEpisode(new Chapter("The Handmaiden's Talea", "2007-10-24"));
    tvShow.addEpisode(new Chapter("Victor (Victrola)", "2007-11-07"));
    tvShow.addEpisode(new Chapter("Seventeen Candles", "2007-11-14"));
    tvShow.addEpisode(new Chapter("Blair Waldorf Must Pie!", "2007-11-28"));
    tvShow.addEpisode(new Chapter("Hi, Society", "2007-12-05"));
    tvShows.add(tvShow);

    tvShow = new TvShow("American Dad", "http://thetvdb.com/banners/_cache/posters/73141-1.jpg",
        "http://thetvdb.com/banners/_cache/fanart/original/73141-12.jpg", 11);
    tvShow.addEpisode(new Chapter("Pilot", "2005-02-06"));
    tvShow.addEpisode(new Chapter("Threat Levels", "2005-05-01"));
    tvShow.addEpisode(new Chapter("Stan Knows Best", "2005-05-08"));
    tvShow.addEpisode(new Chapter("Francine's Flashback", "2005-05-15"));
    tvShow.addEpisode(new Chapter("Roger Codger", "2005-06-05"));
    tvShow.addEpisode(new Chapter("Homeland Insecurity", "2005-06-12"));
    tvShow.addEpisode(new Chapter("Deacon Stan, Jesus Man", "2005-06-19"));
    tvShows.add(tvShow);

    tvShow = new TvShow("The Simpsons", "http://thetvdb.com/banners/_cache/posters/71663-20.jpg",
        "http://thetvdb.com/banners/_cache/fanart/original/71663-30.jpg", 26);
    tvShow.addEpisode(new Chapter("Simpsons Roasting on an Open Fire", "1989-12-17"));
    tvShow.addEpisode(new Chapter("Bart the Genius", "1990-01-14"));
    tvShow.addEpisode(new Chapter("Homer's Odyssey", "1990-01-21"));
    tvShow.addEpisode(new Chapter("There's No Disgrace Like Home", "1990-01-28"));
    tvShow.addEpisode(new Chapter("Bart the General", "1990-02-04"));
    tvShow.addEpisode(new Chapter("Moaning Lisa", "1990-02-11"));
    tvShow.addEpisode(new Chapter("The Call of the Simpsons", "1990-02-18"));
    tvShow.addEpisode(new Chapter("The Telltale Head", "1990-02-25"));
    tvShow.addEpisode(new Chapter("Life on the Fast Lane", "1990-03-18"));
    tvShow.addEpisode(new Chapter("Homer's Night Out", "1990-03-25"));
    tvShow.addEpisode(new Chapter("The Crepes of Wrath", "1990-04-15"));
    tvShow.addEpisode(new Chapter("Krusty Gets Busted", "1990-04-29"));
    tvShow.addEpisode(new Chapter("Some Enchanted Evening", "1990-05-13"));
    tvShows.add(tvShow);

    tvShow = new TvShow("The Mentalist", "http://thetvdb.com/banners/_cache/posters/82459-6.jpg",
        "http://thetvdb.com/banners/_cache/fanart/original/82459-4.jpg", 6);
    tvShow.addEpisode(new Chapter("Pilot", "2008-09-23"));
    tvShow.addEpisode(new Chapter("Red Hair and Silver Tape", "2008-09-30"));
    tvShow.addEpisode(new Chapter("Red Tide", "2008-10-14"));
    tvShow.addEpisode(new Chapter("Ladies in Red", "2008-10-21"));
    tvShow.addEpisode(new Chapter("Redwood", "2008-10-28"));
    tvShow.addEpisode(new Chapter("Red Handed", "2008-11-11"));
    tvShow.addEpisode(new Chapter("Seeing Red", "2008-11-18"));
    tvShow.addEpisode(new Chapter("The Thin Red Line", "2008-11-25"));
    tvShow.addEpisode(new Chapter("Flame Red", "2008-12-02"));
    tvShow.addEpisode(new Chapter("Red Brick and Ivy", "2008-12-16"));
    tvShows.add(tvShow);

    tvShow = new TvShow("Sons of Anarchy", "http://thetvdb.com/banners/_cache/posters/82696-1.jpg",
        "http://thetvdb.com/banners/_cache/fanart/original/82696-18.jpg", 6);
    tvShow.addEpisode(new Chapter("Pilot", "2008-09-03"));
    tvShow.addEpisode(new Chapter("Seeds", "2008-09-10"));
    tvShow.addEpisode(new Chapter("Fun Town", "2008-09-17"));
    tvShow.addEpisode(new Chapter("Patch Over", "2008-09-24"));
    tvShow.addEpisode(new Chapter("Giving Back", "2008-10-01"));
    tvShow.addEpisode(new Chapter("AK 51", "2008-10-08"));
    tvShow.addEpisode(new Chapter("Old Bones", "2008-10-15"));
    tvShow.addEpisode(new Chapter("The Pull", "2008-10-22"));
    tvShow.addEpisode(new Chapter("Hell Followed", "2008-10-29"));
    tvShow.addEpisode(new Chapter("Better Half", "2008-11-05"));
    tvShow.addEpisode(new Chapter("Capybara", "2008-11-12"));
    tvShow.addEpisode(new Chapter("The Sleep of Babies", "2008-11-19"));
    tvShow.addEpisode(new Chapter("The Revelator", "2008-11-26"));
    tvShows.add(tvShow);
  }

  /**
   * @return all available TvShow in the catalog.
   */
  public Collection<TvShow> getTvShows() {
    return (Set<TvShow>) tvShows.clone();
  }

  /**
   * Search a TvShow using a tv show identifier.
   *
   * @param tvShowId used to search inside the catalog.
   * @return a TvShow that matches with the parameter passed as identifier.
   * @throws TvShowNotFoundException if there is no TvShow associated to the id passed as
   * parameter.
   */
  public TvShow getTvShowById(String tvShowId) throws TvShowNotFoundException {
    TvShow result = searchTvShowById(tvShowId);
    if (result == null) {
      throw new TvShowNotFoundException(
          "The identifier" + tvShowId + "is not associated to any TvShow");
    }
    return result;
  }

  private TvShow searchTvShowById(String tvShowId) {
    TvShow result = null;
    for (TvShow tvShow : tvShows) {
      if (tvShow.getTitle().equals(tvShowId)) {
        result = tvShow;
        break;
      }
    }
    return result;
  }
}
