/*
 * analyseur lexical du langage exemple-expr:
 * (voir support de cours CUP)
 *
 * auteur : azim.roussanaly@univ-lorraine.fr
 * (c) 2013
 */

package fr.ul.miage.exemple.generated;
import java_cup.runtime.Symbol;

%%

/* options */
%line
%public
%cup

/* macros */
CRO_OUVR=[\ \t]*\{[\ \t]*
CRO_FERM=[\ \t]*\}[\ \t]*
ESPACE=[\ \t]+
COMMENTAIRE=\/\*([^*]|[\r\n]|(\*+([^*\/]|[\r\n])))*\*\/
NOM=[a-zA-Z]+[a-zA-Z0-9]*
NOMBRE=[0-9]+
EGAL=[\ \t]*=[\ \t]*
PV=[\ \t]*\;[\ \t]*
VIRG=[\ \t]*\,[\ \t]*
RETOUR=([\ \t]*\r[\ \t]*|[\ \t]*\n[\ \t]*|[\ \t]*\r[\ \t]*\n[\ \t]*)+
PLUS=[\ \t]*\+[\ \t]*
MOINS=[\ \t]*\-[\ \t]*
FOIS=[\ \t]*\*[\ \t]*
DIV=[\ \t]*\/[\ \t]*
PO=[\ \t]*\([\ \t]*
PF=[\ \t]*\)[\ \t]*
INF=[\ \t]*\<[\ \t]*
INFEGAL=[\ \t]*\<\=[\ \t]*
SUP=[\ \t]*\>[\ \t]*
SUPEGAL=[\ \t]*\>\=[\ \t]*
DIFF=[\ \t]*\!\=[\ \t]*
%%

/* regles */
{COMMENTAIRE}		{ return new Symbol(sym.COMMENTAIRE, yytext()); }
{CRO_OUVR}			{ return new Symbol(sym.CRO_OUVR, yytext()); }
{CRO_FERM}			{ return new Symbol(sym.CRO_FERM, yytext()); }
"int"				{ return new Symbol(sym.INT, yytext()); }
"nothing"			{ return new Symbol(sym.NOTHING, yytext()); }
"func"				{ return new Symbol(sym.FUNC, yytext()); }
"return"			{ return new Symbol(sym.RETURN, yytext()); }
"si"				{ return new Symbol(sym.SI, yytext()); }
"sinon"				{ return new Symbol(sym.SINON, yytext()); }
"tq"				{ return new Symbol(sym.TQ, yytext()); }
"lire"				{ return new Symbol(sym.LIRE, yytext()); }
"ecrire"			{ return new Symbol(sym.ECRIRE, yytext()); }
{INFEGAL}			{ return new Symbol(sym.INFEGAL, yytext()); }
{SUPEGAL}			{ return new Symbol(sym.SUPEGAL, yytext()); }
{INF}				{ return new Symbol(sym.INF, yytext()); }
{SUP}				{ return new Symbol(sym.SUP, yytext()); }
{DIFF}				{ return new Symbol(sym.DIFF, yytext()); }
{PLUS}				{ return new Symbol(sym.PLUS, yytext()); }
{MOINS}				{ return new Symbol(sym.MOINS, yytext()); }
{FOIS}				{ return new Symbol(sym.FOIS, yytext()); }
{DIV}				{ return new Symbol(sym.DIV, yytext()); }
{PO}				{ return new Symbol(sym.PO, yytext()); }
{PF}				{ return new Symbol(sym.PF, yytext()); }
{EGAL}				{ return new Symbol(sym.EGAL, yytext()); }
{PV}				{ return new Symbol(sym.PV, yytext()); }
{VIRG}				{ return new Symbol(sym.VIRG, yytext()); }
{ESPACE}			{ return new Symbol(sym.ESPACE, yytext()); }
{NOMBRE}			{ return new Symbol(sym.NOMBRE, yytext()); }
{NOM}				{ return new Symbol(sym.NOM, yytext()); }	
{RETOUR}			{ return new Symbol(sym.RETOUR, yytext()); }
.					{ return null;}