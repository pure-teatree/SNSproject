/*
  비동기 접근 , 서버와 연결
*/
//const axios = require('axios').default;

//feed.jsp에서 정보 가져옴
function getAllFeed() {
  axios
    .get('feed', {
      params: {
        command: 'list',
      },
    })
    .then((response) => {
      console.log(response.data);
      document.getElementById('feed').innerHTML = response.data;
    })
    .catch((error) => {
      console.log(error);
      alert('피드를 불러오는데 실패하였습니다.');
    });
}

//profile.jsp에서 정보 가져옴
function getAllProfile() {
  axios
    .get('profile.jsp')
    .then((response) => {
      console.log(response.data);
      document.getElementById('profile').innerHTML = response.data;
    })
    .catch((error) => {
      console.log(error);
      alert('프로필을 불러오는데 실패하였습니다.');
    });
}

function init() {
  getAllFeed();
  getAllProfile();
}

init();
