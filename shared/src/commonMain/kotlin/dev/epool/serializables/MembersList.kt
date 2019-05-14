package dev.epool.serializables

import dev.epool.model.Member
import kotlinx.serialization.*
import kotlinx.serialization.internal.StringDescriptor

// TODO: Remove once https://github.com/ktorio/ktor/issues/969 is fixed.
@Serializable
data class MembersList(val members: List<Member>) {

    @Serializer(MembersList::class)
    companion object : KSerializer<MembersList> {

        override val descriptor = StringDescriptor.withName("MembersList")

        override fun serialize(encoder: Encoder, obj: MembersList) {
            Member.serializer().list.serialize(encoder, obj.members)
        }

        override fun deserialize(decoder: Decoder): MembersList {
            return MembersList(Member.serializer().list.deserialize(decoder))
        }
    }

}