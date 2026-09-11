package polimorfismo.aula

extension (s: String)
    def isEmail: Boolean =
        s.contains("@") && s.contains(".")

val ehEmail = "a@b.com".isEmail // true
