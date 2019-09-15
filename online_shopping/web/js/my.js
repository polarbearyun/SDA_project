
var cate = $("#categories");
if(cate[0]){
	$(".categories").hover(function(){
		$("#menu").show();
	}, function(){
		$("#menu").hide();
	});
}


$("#menu > .cate-list > li").hover(function(){
	$(".sub-list", $(this)).show();
},function(){
	$(".sub-list", $(this)).hide();
});


$(".slidebar-qq").hover(function(){
	$(".qq", $(this)).show();
}, function(){
	$(".qq", $(this)).hide();
});


$(".slidebar-phone").hover(function(){
	$(".phone", $(this)).show();
}, function(){
	$(".phone", $(this)).hide();
});


$(".slidebar-wx").hover(function(){
	$(".pic", $(this)).show();
}, function(){
	$(".pic", $(this)).hide();
});



$.scrollUp({scrollText:''});



$('.icon-plus').parent().click(function(){
    var countInput = $(this).prev('input');
    var num = parseInt(countInput.val()) + 1;
    countInput.val(num);
    countInput.change();
});

$('.icon-minus').parent().click(function(){
    var countInput = $(this).next('input');
    if(countInput.val() <= 1) {
    	return false;
    }
    
    countInput.val(parseInt(countInput.val()) - 1);
    countInput.change();
});

$('input[name=amount]').change(function(){
	
	var amount = parseInt($(this).val());
	var price = parseFloat($(this).parents('tr').find('#price').text());
    var sum = (amount * price).toFixed(2);
    $(this).parents('tr').find('#sum').text(sum);
    countSum();
});


function countSum(){
    var amount = 0;
    var price = 0;
    $('#cart-list>tr').each(function(){
      amount += parseInt($("#amount", $(this)).val());
      price = (parseFloat(price) + parseFloat($("#sum", $(this)).text())).toFixed(2);
    })
    $('#amount-sum').text(amount);
    $('#price-sum').text(price);
}
