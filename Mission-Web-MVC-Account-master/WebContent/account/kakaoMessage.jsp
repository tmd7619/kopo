<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" ></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>  
<script type="text/javascript">

		$(document).ready(function(){
			 Kakao.init('0f673edb4783a374b1213645c23c5f72');
			   var TempleCode = 58278;
			    
			    Kakao.API.request({
			        url: '/v2/api/talk/memo/send',
			        data: {
			            template_id: TempleCode,
			        },
			        success: function(response) {
			        	document.location.href = '/'
			        },
			        fail: function(error) {
			            alert(error)
			        },
			    });
		})

	

</script>