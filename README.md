## JLang
JLang, an advanced Java (freedom) library for simplify the management of languages dynamically

JLang was created to solve a lack of the Java world, the lack of a standard to manage multilingual programs.
In order to make the use of JLang as easy as possible, we have chosen to use as file language for XML files similar to those used on Android.
JLang once started by giving as parameter the external directory (Path or URI) that contains the language files or a directory inside the Jar (String with relative path), read all the xml files (which must be named with the language code in ISO 639-1 if you want auto detection) and will try to automatically detect the system language otherwise it will automatically set to English (en.xml).

**Attention, this library only supports Java 10**

Languages supported for auto detection:
``` Raw
aa	Afar
ab	Abkhazian
af	Afrikaans
ak	Akan
sq	Albanian
am	Amharic
ar	Arabic
an	Aragonese
hy	Armenian
as	Assamese
av	Avaric
ae	Avestan
ay	Aymara
az	Azerbaijani
ba	Bashkir
bm	Bambara
eu	Basque
be	Belarusian
bn	Bengali
bh	Bihari languages
bi	Bislama
bs	Bosnian
br	Breton
bg	Bulgarian
my	Burmese
ca	Catalan; Valencian
ch	Chamorro
ce	Chechen
zh	Chinese
cu	Church Slavic; Old Slavonic; Church Slavonic; Old Bulgarian; Old Church Slavonic
cv	Chuvash
kw	Cornish
co	Corsican
cr	Cree
cs	Czech
da	Danish
dv	Divehi; Dhivehi; Maldivian
nl	Dutch; Flemish
dz	Dzongkha
en	English
eo	Esperanto
et	Estonian
ee	Ewe
fo	Faroese
fj	Fijian
fi	Finnish
fr	French
fy	Western Frisian
ff	Fulah
ka	Georgian
de	German
gd	Gaelic; Scottish Gaelic
ga	Irish
gl	Galician
gv	Manx
el	Greek, Modern (1453-)
gn	Guarani
gu	Gujarati
ht	Haitian; Haitian Creole
ha	Hausa
he	Hebrew
hz	Herero
hi	Hindi
ho	Hiri Motu
hr	Croatian
hu	Hungarian
ig	Igbo
is	Icelandic
io	Ido
ii	Sichuan Yi; Nuosu
iu	Inuktitut
ie	Interlingue; Occidental
ia	Interlingua (International Auxiliary Language Association)
id	Indonesian
ik	Inupiaq
it	Italian
jv	Javanese
ja	Japanese
kl	Kalaallisut; Greenlandic
kn	Kannada
ks	Kashmiri
kr	Kanuri
kk	Kazakh
km	Central Khmer
ki	Kikuyu; Gikuyu
rw	Kinyarwanda
ky	Kirghiz; Kyrgyz
kv	Komi
kg	Kongo
ko	Korean
kj	Kuanyama; Kwanyama
ku	Kurdish
lo	Lao
la	Latin
lv	Latvian
li	Limburgan; Limburger; Limburgish
ln	Lingala
lt	Lithuanian
lb	Luxembourgish; Letzeburgesch
lu	Luba-Katanga
lg	Ganda
mk	Macedonian
mh	Marshallese
ml	Malayalam
mi	Maori
mr	Marathi
ms	Malay
mg	Malagasy
mt	Maltese
mn	Mongolian
na	Nauru
nv	Navajo; Navaho
nr	Ndebele, South; South Ndebele
nd	Ndebele, North; North Ndebele
ng	Ndonga
ne	Nepali
nn	Norwegian Nynorsk; Nynorsk, Norwegian
nb	Bokmål, Norwegian; Norwegian Bokmål
no	Norwegian
ny	Chichewa; Chewa; Nyanja
oc	Occitan (post 1500); Provençal
oj	Ojibwa
or	Oriya
om	Oromo
os	Ossetian; Ossetic
pa	Panjabi; Punjabi
fa	Persian
pi	Pali
pl	Polish
pt	Portuguese
ps	Pushto; Pashto
qu	Quechua
rm	Romansh
ro	Romanian; Moldavian; Moldovan
rn	Rundi
ru	Russian
sg	Sango
sa	Sanskrit
si	Sinhala; Sinhalese
sk	Slovak
sl	Slovenian
se	Northern Sami
sm	Samoan
sn	Shona
sd	Sindhi
so	Somali
st	Sotho, Southern
es	Spanish; Castilian
sc	Sardinian
sr	Serbian
ss	Swati
su	Sundanese
sw	Swahili
sv	Swedish
ty	Tahitian
ta	Tamil
tt	Tatar
te	Telugu
tg	Tajik
tl	Tagalog
th	Thai
bo	Tibetan
ti	Tigrinya
to	Tonga (Tonga Islands)
tn	Tswana
ts	Tsonga
tk	Turkmen
tr	Turkish
tw	Twi
ug	Uighur; Uyghur
uk	Ukrainian
ur	Urdu
uz	Uzbek
ve	Venda
vi	Vietnamese
vo	Volapük
cy	Welsh
wa	Walloon
wo	Wolof
xh	Xhosa
yi	Yiddish
yo	Yoruba
za	Zhuang; Chuang
zu	Zulu
```

## Examples

**Basic JLang File**
``` Xml
// en.xml

<?xml version="1.0"?> 
<resources>
    <string name="app">JLang Demo App</string>
    <string name="hello">Hello guys</string>
</resources>
```

**Initialization of JLang and obtaining a string from the language detected automatically**
``` Java
// /home/jlang/lang is a directory where there are the language files
JLang.start(Paths.get("/home/jlang/lang"));
JLang.get("app") //JLang return value of app string of language detected automatically
```

**Initialization of JLang and obtaining a string from the language set manually**
``` Java
// /home/jlang/lang is a directory where there are the language files
JLang.start(Paths.get("/home/jlang/lang"));
JLang.setLang("it"); // Now JLang use it.xml file
JLang.get("app") //JLang return value of app string of it.xml file
```

**Initialization of JLang with Jar directory and obtaining a string from the language detected automatically*
``` Java
// Main.class is a your class for request resources, main/strings/langs is a relative path in Jar
JLang.start(Main.class, "main/strings/langs"); 
JLang.get("app") //JLang return value of app string of detected automatically
```

## Build
Build JLang is very simple, just follow this guide which will explain the compilation only for operating systems GNU/Linux (or Unix) based, no guaranteed support for windows

**Requirements**
  - Gradle installed in your machine (or use Gradle wrapper included in the project)
  - Java 10 JDK installed correctly on your computer 
 
**Build**
  - Check Java version
  ``` Bash
  java --version
  ```
  - Clone JLang repository
  ``` Bash
  git clone https://github.com/ErnyTech/JLang.git
  cd JLang
  ```
  - Start Gradle build
  ``` Bash
  gradle jar
  ```
  - Go to JLang jars
  ``` Bash
  cd build/libs
  ls
  ```
## Copyright info
    JLang, an advanced Java (freedom) library for simplify the management of languages dynamically
    Copyright (C) 2018 Ernesto Castellotti

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as
    published by the Free Software Foundation, either version 3 of the
    License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with this program.  If not, contact the owner of copyrights
