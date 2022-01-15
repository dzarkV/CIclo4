from rest_framework import generics
from django_filters.rest_framework import DjangoFilterBackend
from authApp.models.user import User
from authApp.serializers.userSerializer import UserSerializer

class UserListAllView(generics.ListAPIView):
    queryset = User.objects.all()
    serializer_class = UserSerializer
    filter_fields = ('username','name')
