<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Text data storage system</title>
        <link href="/css/storage.css" rel="stylesheet">
    </head>
    <body>
        <div class="content" >

            <h2 class="title">Text data storage system</h2><br/>

            <c:if test="${message != null}" >
                <div class="confirm-message">
                    <c:out value="${message}"/>
                </div>
                <br/><br/>
            </c:if>

            <form action="/store" method="post" >

                <div>
                    <textarea name="text" id="text"></textarea>
                </div>
                <div>
                    <label for="storageName">Storage Name</label><br/>
                    <input name="storageName" id="storageName" />
                    <br/><br/>
                </div>

                <div>
                    <input name="tags" id="bold" value="BOLD" type="checkbox">
                    <label for="bold"><b>bold</b></label>
                </div>
                <div>
                    <input name="tags" id="underscore" value="UNDERSCORE" type="checkbox">
                    <label for="underscore"><u>underscore</u></label>
                </div>
                <div>
                    <input name="tags" id="italic" value="ITALIC" type="checkbox">
                    <label for="italic"><i>italic</i></label>
                </div>
                <div>
                    <input name="tags" id="subscripted" value="SUBSCRIPTED" type="checkbox">
                    <label for="subscripted"><sub>subscripted</sub></label>
                </div>
                <div>
                    <input name="tags" id="superscripted" value="SUPERSCRIPTED" type="checkbox">
                    <label for="superscripted"><sup>superscripted</sup></label>
                </div>
                <div>
                    <br/>
                    <input type="submit" value="Submit"/>
                </div>
            </form>
        </div>

        <script src="/js/storage.js"></script>
    </body>
</html>