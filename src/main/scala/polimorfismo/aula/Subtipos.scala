package polimorfismo.aula

trait Notifier:
    def send(msg: String): Unit

class EmailNotifier extends Notifier:
    def send(msg: String) = println(s"Email: $msg")

class SmsNotifier extends Notifier:
    def send(msg: String) = println(s"SMS: $msg")

def alertAll(notifiers: List[Notifier], msg: String): Unit =
    notifiers.foreach(_.send(msg))
