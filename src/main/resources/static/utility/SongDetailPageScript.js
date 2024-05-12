const lyricsContainer = document.querySelector('.lyric-container');
const lyricString = "You would not believe your eyes/If ten million fireflies/Lit up the world as I fell asleep/'Cause they fill the open air/And leave teardrops everywhere/You'd think me rude but I would just stand and stare/I'd like to make myself believe that planet Earth turns slowly/It's hard to say that I'd rather stay awake when I'm asleep/'Cause everything is never as it seems/'Cause I'd get a thousand hugs/From ten thousand lightning bugs/As they tried to teach me how to dance/A foxtrot above my head/A sock hop beneath my bed/A disco ball is just hanging by a thread (thread, thread)/I'd like to make myself believe that planet Earth turns slowly/It's hard to say that I'd rather stay awake when I'm asleep/'Cause everything is never as it seems (when I fall asleep)/";

const lyrics = lyricString.split('/');
lyrics.forEach((line)=>{
    const lyricElement = document.createElement('p');
    lyricElement.classList.add('lyric-line');
    lyricElement.textContent = line;

    lyricsContainer.appendChild(lyricElement);
})