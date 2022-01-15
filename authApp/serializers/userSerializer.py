from rest_framework import serializers
from authApp.models.user import User

class UserSerializer(serializers.ModelSerializer):
    class Meta:
        model = User
        fields = ['id', 'username', 'password', 'name', 'email']

    def to_representation(self, obj):
        user = User.objects.get(id=obj.id)
        return {
            "username"  : user.username,
            "name"      : user.name,
            "email"     : user.email,
            "contract_date": user.contract_date
        }
