<%@page contentType="text/html" pageEncoding="UTF-8"%>
<footer>
            <hr>
            <!-- Purchase a site license to remove this link from the footer: http://www.portnine.com/bootstrap-themes -->
            <p class="pull-right">A <a href="http://www.portnine.com/bootstrap-themes" target="_blank">Free Bootstrap Theme</a> by <a href="http://www.portnine.com" target="_blank">Portnine</a></p>
            <p>&copy; 2012 <a href="http://www.portnine.com" target="_blank">Portnine</a></p>
        </footer>
   
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function () {
            $('.demo-cancel-click').click(function () { return false; });
        });
    </script>
    <script>
        function ShowHide(sender) {
            var idItem = sender.getAttribute("link");
            var item = document.getElementById(idItem);
            var itemClass = item.className;
            if (itemClass.indexOf("in") != -1) {
                item.className = itemClass.replace("in","");
            } else {
                item.className += " in";
            }
        };
        function ShowHideLogOut(sender) {
            var item = document.getElementById("fat-menu");
            var itemClass = item.className;
            if (itemClass.indexOf("open") != -1) {
                item.className = itemClass.replace("open","");
            } else {
                item.className += " open";
            }
        };
    </script>
     