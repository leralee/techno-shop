

$(document).ready(function() {
    $("#logoutLink").on("click", function(e) {
        e.preventDefault();
        document.logoutForm.submit();
    });
    customizeDropDownMenu();
});

function customizeDropDownMenu(){
    $(".navbar .dropdown").hover(
        function (){
            $(this).find('.dropdown-menu').first().stop(true,true).delay(250).slideDown();
        },
        function (){
            $(this).find('.dropdown-menu').first().stop(true,true).delay(100).slideUp();
        });
    $(".dropdown > a").click(function (){
        location.href = this.href;
    });
}


$(document).ready(function() {
$('#sidebarCollapse').on('click', function() {
    $('#sidebar, #content').toggleClass('active');
    $('.collapse.in').toggleClass('in');
    $('a[aria-expanded=true]').attr('aria-expanded', 'false');
});
});
