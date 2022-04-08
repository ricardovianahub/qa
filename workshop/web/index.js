function writeMe() {
    document.write("<div style='font-size: 35px;font-style: italic'>Hello world!</div><br/>");
    document.write("I will count from 1 to 10!!!");
    document.write("<ul>");
    for (var i = 1; i <= 20; i+=2) {
        document.write("<li>This is item " + i);
    }
    document.write("</ul>");
}
