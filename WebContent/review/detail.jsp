<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>review/detail.html</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="../jquery/jquery-3.6.0.min.js"></script>

<script>
	<%
	String cafeNum = request.getParameter("cafe_num");
	%>
	//윈도우 페이지 여는 순간 onload
	window.onload = function() { //onload 이벤트는 페이지가 다 로딩된 다음에 실행함.
		loadCafeOne();
	}
	//상세 조회하는 함수
	function loadCafeOne() {
		$.ajax({
			url : '../PetCafeOneServlet',
			type : 'post', //요청방식
			data : { //서버로 전송할 전체 리스트 페이지에서 클릭한 cafe_num 데이터
				cafeNum : "<%=cafeNum%>"
			},
			dataType : 'json',
			success : function(result) { //result: servlet에서 반환되는 변수명
				image.setAttribute('src', '../image/' + result.cafeImage);
				document.getElementById('cafename').value = result.cafeName;
				document.getElementById('addr').value = result.cafeAdd;
				document.getElementById('call').value = result.cafePhone;
				document.getElementById('time').value = result.cafeTime;
				document.getElementById('type').value = result.cafeType;
				console.log(result);
			},
			error : function(reject) {
				window.alert('프로그램 실행 오류');
			}
		});
	}
	
	//리뷰 등록하기
	function review() {
		
	}
	
	
	//등록된 후기 보여주기
	function showReview() {
		$.ajax({
			url : '../PetCafeOneServlet',
			type : 'post',
			data : {
				writer : memberId,
				score : cafeScore,
				content : content
			},
			dataType : 'json',
			success : function(result) {
				console.log(result);
				
			},
			error : function(reject){
				console.log(reject);
				
			}
		}) 
	}
	

	
</script>
<style>
nav { height: 100px; }
</style>
</head>

<body>
	<nav class="navbar navbar-expand-xxl bg-dark navbar-dark ">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img src="../image/로고사진.jpg"
				alt="Logo" style="width: 100px; align-content: center;"
				class="rounded-pill" onclick="location.href='../petcafe/Main.html'"> 어서오시개
			</a>
		</div>
	</nav>

	<br>
	<br>
	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-4">
			<img src="../image" alt="카페사진" id="image" style="width: 550px;">
		</div>
		<div class="col-sm-4">
			<form action="">
				카페이름<input type="text" class="form-control" value=""
					style="text-align: center;" id="cafename"
					name="cafename"><br> 주소<input type="text"
					class="form-control" value="" style="text-align: center;" id="addr"
					name="addr"><br> 연락처<input type="text"
					class="form-control" value="" style="text-align: center;" id="call"
					name="call"><br> 영업시간<input type="text"
					class="form-control" value="" style="text-align: center;" id="time"
					name="time"><br> 유형<input type="text"
					class="form-control" value="" style="text-align: center;" id="type"
					name="type"><br>
			</form>
		</div>
		<div class="col-sm-2"></div>
	</div>

	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<br>
			<h3>후기게시판</h3>
			<br>
			<form action="" name="ReviewForm">
				<table class="table">
					<thead class="table-dark">
						<tr>
							<th style="text-align: center;">작성자</th>
							<th style="text-align: center;">평점</th>
							<th style="text-align: center;">후기</th>
							<th style="text-align: center;">수정</th>
							<th style="text-align: center;">삭제</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
			</form>
			<br>

			<form action="#" name="cafeOne">
				<div class="mb-3 mt-3">
					<label for="comment">후기글 작성</label>
					<textarea class="form-control" rows="5" id="comment" name="text"></textarea>
				</div>

				<div class="dropdown">
					<button type="button"
						class="btn btn-primary dropdown-toggle btn-sm"
						data-bs-toggle="dropdown">평점</button>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item">5</a></li>
						<li><a class="dropdown-item">4.5</a></li>
						<li><a class="dropdown-item">4</a></li>
						<li><a class="dropdown-item">3.5</a></li>
						<li><a class="dropdown-item">3</a></li>
						<li><a class="dropdown-item">2.5</a></li>
						<li><a class="dropdown-item">2</a></li>
						<li><a class="dropdown-item">1.5</a></li>
						<li><a class="dropdown-item">1</a></li>
					</ul>
				</div>
				<br>

				<button type="submit" class="btn btn-primary btn-sm">후기등록</button>
			</form>

		</div>
		<div class="col-sm-2"></div>

	</div>

</body>

</html>