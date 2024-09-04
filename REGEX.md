## HTML *style* attribute
(\s+style\s*=\s*"\s*[^"]\s*"\s+|\s+style\s*=\s*'\s*[^']\s*'\s+)

# TYPES
## Booleans
REGEX_XSD_BOOLEAN   = r"[Tt][Rr][Uu][Ee]|[Ff][Aa][Ll][Ss][Ee]|1|0"
## Numeric values
REGEX_SEP_NUMBER    = r"[.]"
REGEX_XSD_INTEGER   = r"[+-]?[0-9]+"
REGEX_XSD_DECIMAL   = r"[+-]?([0-9]+(\.[0-9]*)?|\.[0-9]+)"
REGEX_INFINITY      = r"[Ii][Nn][Ff]"
REGEX_NAN           = r"[Nn][Aa][Nn]"
REGEX_XSD_FLOAT     = r"[+-]?([0-9]+("+REGEX_SEP_NUMBER+r"[0-9]*)?|"+REGEX_SEP_NUMBER+r"[0-9]+)([Ee][+-]?[[0-9]]+)?|[+-]?"+REGEX_INFINITY+"|"+REGEX_NAN # TODO: strict: 32 bit
REGEX_XSD_DOUBLE    = r"[+-]?([0-9]+("+REGEX_SEP_NUMBER+r"[0-9]*)?|"+REGEX_SEP_NUMBER+r"[0-9]+)([Ee][+-]?[[0-9]]+)?|[+-]?"+REGEX_INFINITY+"|"+REGEX_NAN # TODO: strict: 64 bit
## Dates, times, and durations
REGEX_SEP_DATE      = r"[-/]" # (!) default value: "-"
REGEX_SEP_TIME      = r"[:]" # (!) default value: ":"
REGEX_FRAG_YEAR     = r"([1-9][0-9]{3,}|0[0-9]{3})"
REGEX_FRAG_MONTH    = r"(0[1-9]|1[0-2])"
REGEX_FRAG_DAY      = r"(0[1-9]|[12][0-9]|3[01])"
REGEX_FRAG_HOUR     = r"([01][0-9]|2[0-3])"
REGEX_FRAG_MINUTE   = r"[0-5][0-9]"
REGEX_FRAG_SECOND   = r"[0-5][0-9](\.[0-9]+)?" # TODO: stric: with microseconds
REGEX_TIMEZONE_OFFSET = r"(Z|[+-]((0[0-9]|1[0-3]):[0-5][0-9]|14:00))"
REGEX_XSD_GYEAR     = REGEX_FRAG_YEAR+REGEX_TIMEZONE_OFFSET+r"?" # "timezoneOffset" remains optional
REGEX_XSD_GMONTH    = REGEX_FRAG_MONTH+REGEX_TIMEZONE_OFFSET+r"?" # "timezoneOffset" remains optional
REGEX_XSD_GDAY      = REGEX_FRAG_DAY+REGEX_TIMEZONE_OFFSET+r"?" # "timezoneOffset" remains optional
REGEX_XSD_GYEARMONTH= REGEX_FRAG_YEAR+r"-"+REGEX_FRAG_MONTH+REGEX_TIMEZONE_OFFSET+r"?" # "timezoneOffset" remains optional
REGEX_XSD_GMONTHDAY = r"--"+REGEX_FRAG_MONTH+r"-"+REGEX_FRAG_DAY+REGEX_TIMEZONE_OFFSET+r"?" # "timezoneOffset" remains optional
REGEX_XSD_DATE      = r"-?"+REGEX_FRAG_YEAR+REGEX_SEP_DATE+REGEX_FRAG_MONTH+REGEX_SEP_DATE+REGEX_FRAG_DAY+REGEX_TIMEZONE_OFFSET+r"?" # "timezoneOffset" remains optional
REGEX_XSD_TIME      = r"("+REGEX_FRAG_HOUR+REGEX_SEP_TIME+REGEX_FRAG_MINUTE+REGEX_SEP_TIME+REGEX_FRAG_SECOND+r"|(24:00:00(\.0+)?))"+REGEX_TIMEZONE_OFFSET+r"?"  # "timezoneOffset" remains optional
REGEX_XSD_DATETIME  = REGEX_XSD_DATE+r"T"+REGEX_XSD_TIME # strictly without "timezoneOffset"
REGEX_XSD_DATETIMESTAMP = REGEX_XSD_DATETIME+REGEX_TIMEZONE_OFFSET
REGEX_XSD_DURATION  = r"-?P[0-9]+Y?([0-9]+M)?([0-9]+D)?(T([0-9]+H)?([0-9]+M)?([0-9]+(\.[0-9]+)?S)?)?"
## Binaries
REGEX_XSD_HEXBINARY = r"([0-9a-fA-F]{2})+" # NOTE: due to this string can be empty, we force the "+" closure instead of "*"
REGEX_XSD_BASE64BINARY  = r"(([A-Za-z0-9+/] ?){4})*(([A-Za-z0-9+/] ?){3}[A-Za-z0-9+/]|([A-Za-z0-9+/] ?){2}[AEIMQUYcgkosw048] ?=|[A-Za-z0-9+/] ?[AQgw] ?= ?=)"
    ### Text based
    #### https://www.iana.org/assignments/uri-schemes/uri-schemes.xhtml (Permanent ones only)
REGEX_IANA_URI_SCHEME = r'([A-Za-z])[A-Za-z0-9+\-\.]*' if not self.use_permanent_iana_uri_scheme else r'(aaa|aaas|about|acap|acct|cap|cid|coap|coap[+]tcp|coap[+]ws|coaps|coaps[+]tcp|coaps[+]ws|crid|data|dav|dict|dns|dtn|example|file|ftp|geo|go|gopher|h323|http|https|iax|icap|im|imap|info|ipn|ipp|ipps|iris|iris.beep|iris.lwz|iris.xpc|iris.xpcs|jabber|ldap|leaptofrogans|mailto|mid|msrp|msrps|mt|mtqp|mupdate|news|nfs|ni|nih|nntp|opaquelocktoken|pkcs11|pop|pres|reload|rtsp|rtsps|rtspu|service|session|shttp (OBSOLETE)|sieve|sip|sips|sms|snmp|soap.beep|soap.beeps|stun|stuns|tag|tel|telnet|tftp|thismessage|tip|tn3270|turn|turns|tv|urn|vemmi|vnc|ws|wss|xcon|xcon-userid|xmlrpc.beep|xmlrpc.beeps|xmpp|z39.50r|z39.50s)'
    #### valid URI: https://www.w3.org/2011/04/XMLSchema/TypeLibrary-IRI-RFC3987.xsd
REGEX_XSD_ANYURI = r"(("+REGEX_IANA_URI_SCHEME+"):((//(((([A-Za-z0-9\-\._~ -퟿豈-﷏ﷰ-￯𐀀-🿽𠀀-𯿽𰀀-𿿽񀀀-񏿽񐀀-񟿽񠀀-񯿽񰀀-񿿽򀀀-򏿽򐀀-򟿽򠀀-򯿽򰀀-򿿽󀀀-󏿽󐀀-󟿽󡀀-󯿽!$&'()*+,;=:]|(%[0-9A-Fa-f][0-9A-Fa-f]))*@))?((\[((((([0-9A-Fa-f]{0,4}:)){6}(([0-9A-Fa-f]{0,4}:[0-9A-Fa-f]{0,4})|(([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5]))\.([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5]))\.([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5]))\.([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5])))))|(::(([0-9A-Fa-f]{0,4}:)){5}(([0-9A-Fa-f]{0,4}:[0-9A-Fa-f]{0,4})|(([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5]))\.([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5]))\.([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5]))\.([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5])))))|(([0-9A-Fa-f]{0,4})?::(([0-9A-Fa-f]{0,4}:)){4}(([0-9A-Fa-f]{0,4}:[0-9A-Fa-f]{0,4})|(([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5]))\.([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5]))\.([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5]))\.([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5])))))|((((([0-9A-Fa-f]{0,4}:))?[0-9A-Fa-f]{0,4}))?::(([0-9A-Fa-f]{0,4}:)){3}(([0-9A-Fa-f]{0,4}:[0-9A-Fa-f]{0,4})|(([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5]))\.([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5]))\.([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5]))\.([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5])))))|((((([0-9A-Fa-f]{0,4}:)){0,2}[0-9A-Fa-f]{0,4}))?::(([0-9A-Fa-f]{0,4}:)){2}(([0-9A-Fa-f]{0,4}:[0-9A-Fa-f]{0,4})|(([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5]))\.([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5]))\.([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5]))\.([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5])))))|((((([0-9A-Fa-f]{0,4}:)){0,3}[0-9A-Fa-f]{0,4}))?::[0-9A-Fa-f]{0,4}:(([0-9A-Fa-f]{0,4}:[0-9A-Fa-f]{0,4})|(([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5]))\.([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5]))\.([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5]))\.([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5])))))|((((([0-9A-Fa-f]{0,4}:)){0,4}[0-9A-Fa-f]{0,4}))?::(([0-9A-Fa-f]{0,4}:[0-9A-Fa-f]{0,4})|(([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5]))\.([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5]))\.([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5]))\.([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5])))))|((((([0-9A-Fa-f]{0,4}:)){0,5}[0-9A-Fa-f]{0,4}))?::[0-9A-Fa-f]{0,4})|((((([0-9A-Fa-f]{0,4}:)){0,6}[0-9A-Fa-f]{0,4}))?::))|(v[0-9A-Fa-f]+\.[A-Za-z0-9\-\._~!$&'()*+,;=:]+))\])|(([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5]))\.([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5]))\.([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5]))\.([0-9]|([1-9][0-9])|(1([0-9]){2})|(2[0-4][0-9])|(25[0-5])))|(([A-Za-z0-9\-\._~ -퟿豈-﷏ﷰ-￯𐀀-🿽𠀀-𯿽𰀀-𿿽񀀀-񏿽񐀀-񟿽񠀀-񯿽񰀀-񿿽򀀀-򏿽򐀀-򟿽򠀀-򯿽򰀀-򿿽󀀀-󏿽󐀀-󟿽󡀀-󯿽]|(%[0-9A-Fa-f][0-9A-Fa-f])|[!$&'()*+,;=]))*)((:[0-9]*))?)((/(([A-Za-z0-9\-\._~ -퟿豈-﷏ﷰ-￯𐀀-🿽𠀀-𯿽𰀀-𿿽񀀀-񏿽񐀀-񟿽񠀀-񯿽񰀀-񿿽򀀀-򏿽򐀀-򟿽򠀀-򯿽򰀀-򿿽󀀀-󏿽󐀀-󟿽󡀀-󯿽]|(%[0-9A-Fa-f][0-9A-Fa-f])|[!$&'()*+,;=:@]))*))*)|(/(((([A-Za-z0-9\-\._~ -퟿豈-﷏ﷰ-￯𐀀-🿽𠀀-𯿽𰀀-𿿽񀀀-񏿽񐀀-񟿽񠀀-񯿽񰀀-񿿽򀀀-򏿽򐀀-򟿽򠀀-򯿽򰀀-򿿽󀀀-󏿽󐀀-󟿽󡀀-󯿽]|(%[0-9A-Fa-f][0-9A-Fa-f])|[!$&'()*+,;=:@]))+((/(([A-Za-z0-9\-\._~ -퟿豈-﷏ﷰ-￯𐀀-🿽𠀀-𯿽𰀀-𿿽񀀀-񏿽񐀀-񟿽񠀀-񯿽񰀀-񿿽򀀀-򏿽򐀀-򟿽򠀀-򯿽򰀀-򿿽󀀀-󏿽󐀀-󟿽󡀀-󯿽]|(%[0-9A-Fa-f][0-9A-Fa-f])|[!$&'()*+,;=:@]))*))*))?)|((([A-Za-z0-9\-\._~ -퟿豈-﷏ﷰ-￯𐀀-🿽𠀀-𯿽𰀀-𿿽񀀀-񏿽񐀀-񟿽񠀀-񯿽񰀀-񿿽򀀀-򏿽򐀀-򟿽򠀀-򯿽򰀀-򿿽󀀀-󏿽󐀀-󟿽󡀀-󯿽]|(%[0-9A-Fa-f][0-9A-Fa-f])|[!$&'()*+,;=:@]))+((/(([A-Za-z0-9\-\._~ -퟿豈-﷏ﷰ-￯𐀀-🿽𠀀-𯿽𰀀-𿿽񀀀-񏿽񐀀-񟿽񠀀-񯿽񰀀-񿿽򀀀-򏿽򐀀-򟿽򠀀-򯿽򰀀-򿿽󀀀-󏿽󐀀-󟿽󡀀-󯿽]|(%[0-9A-Fa-f][0-9A-Fa-f])|[!$&'()*+,;=:@]))*))*)|)((\?(([A-Za-z0-9\-\._~ -퟿豈-﷏ﷰ-￯𐀀-🿽𠀀-𯿽𰀀-𿿽񀀀-񏿽񐀀-񟿽񠀀-񯿽񰀀-񿿽򀀀-򏿽򐀀-򟿽򠀀-򯿽򰀀-򿿽󀀀-󏿽󐀀-󟿽󡀀-󯿽]|(%[0-9A-Fa-f][0-9A-Fa-f])|[!$&'()*+,;=:@])|[-󰀀-󿿽􀀀-􏿽/?])*))?((#((([A-Za-z0-9\-\._~ -퟿豈-﷏ﷰ-￯𐀀-🿽𠀀-𯿽𰀀-𿿽񀀀-񏿽񐀀-񟿽񠀀-񯿽񰀀-񿿽򀀀-򏿽򐀀-򟿽򠀀-򯿽򰀀-򿿽󀀀-󏿽󐀀-󟿽󡀀-󯿽]|(%[0-9A-Fa-f][0-9A-Fa-f])|[!$&'()*+,;=:@])|/|\?))*))?)"
    #### TODO: more...
