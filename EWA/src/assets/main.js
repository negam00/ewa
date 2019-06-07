// Toggletext function
jQuery.fn.extend({
    toggleText: function (a, b){
        var that = this;
            if (that.text() != a && that.text() != b){
                that.text(a);
            }
            else
            if (that.text() == a){
                that.text(b);
            }
            else
            if (that.text() == b){
                that.text(a);
            }
        return this;
    }
});

$(document).ready(function(){

	// Add people search
	$('body').on("keyup",'.search-people', function(){

		var search = $(this).val().toLowerCase();

		$('.invite-window .person').each(function(){

			var result = $(this).find('.name').text().toLowerCase();
			result += $(this).find('.email').text().toLowerCase();

			if ( result.indexOf(search) != -1){
				$(this).show();
			}else{
				$(this).hide();
			}
		
		});
	});

	// Search restaurants
	$('body').on("keyup",'.search-restaurants', function(){

		var search = $(this).val().toLowerCase();

		$('.restaurant-card').each(function(){

			// dont check if element is hidden by category filter
			if ( !$(this).hasClass("hidden-by-filter") ){

				var result = $(this).find("h4").text().toLowerCase();

				if ( result.indexOf(search) != -1){
					$(this).show();
				}else{
					$(this).hide();
				}

			}
			
		});
	});

	// Restaurant category filter
	$('.select-restaurants').change(function(){

		var search = $(this).val().toLowerCase();
		
		$('.restaurant-card').each(function(){

			var result = $(this).find(".category").text().toLowerCase();

			if ( result.indexOf(search) != -1){
				$(this).show().removeClass("hidden-by-filter");
			}else{
				$(this).hide().addClass("hidden-by-filter");
			}
			
		});

	});

	// Place order button
	$('body').delegate('.order-button', "click", function() {  
		$('.modal, .backdrop').addClass('active');
	});

	// Close modal if backdrop or buttons are clicked
	$('body').delegate('.backdrop.active, .submit-order, .cancel-order', "click", function() {  
		$('.modal, .backdrop').removeClass('active');
	});

	// Toggle add people on mobile
	$('body').delegate('.expand-add-people', "click", function() {  
		if ( $('body').width() < 840 ) {
			$('.add-people').slideToggle(200);
			$('.expand-add-people i').toggleText('expand_more','expand_less');
		}
	});
	
	// Event overview add people
	$('body').delegate('.person .checkbox', "change", function() {  
		$(this).prop('checked', true);
		$(this).siblings("i").text("done").addClass("done");
	});

	// Hide menu on login and register page
	if ( $('#login-page, #register-page').length ){
		$('.mdl-layout__drawer-button, .mdl-navigation.mdl-layout--large-screen-only').hide();
		$('.mdl-layout__header-row').css("padding", "0px 16px");
	}

});

$(window).resize(function() {
	// Add people responsive
	if ( $('body').width() >= 840 ) {
		$('.add-people').show();
	}else{
		$('.add-people').hide();
		$('.expand-add-people i').text('expand_more');
	}
});
