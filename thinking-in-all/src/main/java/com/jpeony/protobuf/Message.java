package com.jpeony.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Message {
    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    public static final class MessageBase extends GeneratedMessageV3 implements MessageBaseOrBuilder {
        private int bitField0_;

        public static final int CLIENTID_FIELD_NUMBER = 1;

        private volatile Object clientId_;

        public static final int CMD_FIELD_NUMBER = 2;

        private int cmd_;

        public static final int DATA_FIELD_NUMBER = 3;

        private volatile Object data_;

        private byte memoizedIsInitialized;

        private static final long serialVersionUID = 0L;

        private MessageBase(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MessageBase() {
            this.memoizedIsInitialized = -1;
            this.clientId_ = "";
            this.cmd_ = 1;
            this.data_ = "";
        }

        @Override
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MessageBase(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString byteString1;
                    int rawValue;
                    ByteString bs;
                    Command.CommandType value;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10:
                            byteString1 = input.readBytes();
                            this.bitField0_ |= 0x1;
                            this.clientId_ = byteString1;
                            break;
                        case 16:
                            rawValue = input.readEnum();
                            value = Command.CommandType.valueOf(rawValue);
                            if (value == null) {
                                unknownFields.mergeVarintField(2, rawValue);
                                break;
                            }
                            this.bitField0_ |= 0x2;
                            this.cmd_ = rawValue;
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.data_ = bs;
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e)).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Message.internal_static_cn_myzf_common_protobuf_MessageBase_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Message.internal_static_cn_myzf_common_protobuf_MessageBase_fieldAccessorTable.ensureFieldAccessorsInitialized(MessageBase.class, Builder.class);
        }

        @Override
        public boolean hasClientId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        @Override
        public String getClientId() {
            Object ref = this.clientId_;
            if (ref instanceof String) {
              return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
              this.clientId_ = s;
            }
            return s;
        }

        @Override
        public ByteString getClientIdBytes() {
            Object ref = this.clientId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.clientId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        @Override
        public boolean hasCmd() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        @Override
        public Command.CommandType getCmd() {
            Command.CommandType result = Command.CommandType.valueOf(this.cmd_);
            return (result == null) ? Command.CommandType.AUTH : result;
        }

        @Override
        public boolean hasData() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        @Override
        public String getData() {
            Object ref = this.data_;
            if (ref instanceof String) {
              return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
              this.data_ = s;
            }
            return s;
        }

        @Override
        public ByteString getDataBytes() {
            Object ref = this.data_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.data_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        @Override
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
              return true;
            }
            if (isInitialized == 0) {
              return false;
            }
            if (!hasClientId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasCmd()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            if ((this.bitField0_ & 0x1) == 1) {
              GeneratedMessageV3.writeString(output, 1, this.clientId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
              output.writeEnum(2, this.cmd_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
              GeneratedMessageV3.writeString(output, 3, this.data_);
            }
            this.unknownFields.writeTo(output);
        }

        @Override
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
              return size;
            }
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) {
              size += GeneratedMessageV3.computeStringSize(1, this.clientId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
              size +=
                      CodedOutputStream.computeEnumSize(2, this.cmd_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
              size += GeneratedMessageV3.computeStringSize(3, this.data_);
            }
            size += this.unknownFields.getSerializedSize();
            this.memoizedSize = size;
            return size;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
              return true;
            }
            if (!(obj instanceof MessageBase)) {
              return super.equals(obj);
            }
            MessageBase other = (MessageBase) obj;
            boolean result = true;
            result = (result && hasClientId() == other.hasClientId());
            if (hasClientId()) {
              result = (result && getClientId().equals(other.getClientId()));
            }
            result = (result && hasCmd() == other.hasCmd());
            if (hasCmd()) {
              result = (result && this.cmd_ == other.cmd_);
            }
            result = (result && hasData() == other.hasData());
            if (hasData()) {
              result = (result && getData().equals(other.getData()));
            }
            result = (result && this.unknownFields.equals(other.unknownFields));
            return result;
        }

        @Override
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
              return this.memoizedHashCode;
            }
            int hash = 41;
            hash = 19 * hash + getDescriptor().hashCode();
            if (hasClientId()) {
                hash = 37 * hash + 1;
                hash = 53 * hash + getClientId().hashCode();
            }
            if (hasCmd()) {
                hash = 37 * hash + 2;
                hash = 53 * hash + this.cmd_;
            }
            if (hasData()) {
                hash = 37 * hash + 3;
                hash = 53 * hash + getData().hashCode();
            }
            hash = 29 * hash + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static MessageBase parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (MessageBase) PARSER.parseFrom(data);
        }

        public static MessageBase parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MessageBase) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MessageBase parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MessageBase) PARSER.parseFrom(data);
        }

        public static MessageBase parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MessageBase) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MessageBase parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MessageBase) PARSER.parseFrom(data);
        }

        public static MessageBase parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MessageBase) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MessageBase parseFrom(InputStream input) throws IOException {
            return
                    (MessageBase) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MessageBase parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return
                    (MessageBase) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MessageBase parseDelimitedFrom(InputStream input) throws IOException {
            return
                    (MessageBase) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MessageBase parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return
                    (MessageBase) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MessageBase parseFrom(CodedInputStream input) throws IOException {
            return
                    (MessageBase) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MessageBase parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return
                    (MessageBase) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MessageBase prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder())
                    .mergeFrom(this);
        }

        @Override
        protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Message.MessageBaseOrBuilder {
            private int bitField0_;

            private Object clientId_;

            private int cmd_;

            private Object data_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Message.internal_static_cn_myzf_common_protobuf_MessageBase_descriptor;
            }

            @Override
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Message.internal_static_cn_myzf_common_protobuf_MessageBase_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(Message.MessageBase.class, Builder.class);
            }

            private Builder() {
                this.clientId_ = "";
                this.cmd_ = 1;
                this.data_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                this.clientId_ = "";
                this.cmd_ = 1;
                this.data_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Message.MessageBase.alwaysUseFieldBuilders) {

                };
            }

            @Override
            public Builder clear() {
                super.clear();
                this.clientId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.cmd_ = 1;
                this.bitField0_ &= 0xFFFFFFFD;
                this.data_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            @Override
            public Descriptors.Descriptor getDescriptorForType() {
                return Message.internal_static_cn_myzf_common_protobuf_MessageBase_descriptor;
            }

            @Override
            public Message.MessageBase getDefaultInstanceForType() {
                return Message.MessageBase.getDefaultInstance();
            }

            @Override
            public Message.MessageBase build() {
                Message.MessageBase result = buildPartial();
                if (!result.isInitialized()) {
                  throw newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public Message.MessageBase buildPartial() {
                Message.MessageBase result = new Message.MessageBase(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.clientId_ = this.clientId_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.cmd_ = this.cmd_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.data_ = this.data_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @Override
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override
            public Builder setField(Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.setField(field, value);
            }

            @Override
            public Builder clearField(Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }

            @Override
            public Builder clearOneof(Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }

            @Override
            public Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }

            @Override
            public Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }

            @Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof Message.MessageBase) {
                  return mergeFrom((MessageBase) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Message.MessageBase other) {
                if (other == Message.MessageBase.getDefaultInstance()) {
                  return this;
                }
                if (other.hasClientId()) {
                    this.bitField0_ |= 0x1;
                    this.clientId_ = other.clientId_;
                    onChanged();
                }
                if (other.hasCmd()) {
                  setCmd(other.getCmd());
                }
                if (other.hasData()) {
                    this.bitField0_ |= 0x4;
                    this.data_ = other.data_;
                    onChanged();
                }
                mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @Override
            public final boolean isInitialized() {
                if (!hasClientId())
                    return false;
                if (!hasCmd())
                    return false;
                return true;
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Message.MessageBase parsedMessage = null;
                try {
                    parsedMessage = (Message.MessageBase) Message.MessageBase.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Message.MessageBase) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                      mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            @Override
            public boolean hasClientId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            @Override
            public String getClientId() {
                Object ref = this.clientId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                      this.clientId_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }

            @Override
            public ByteString getClientIdBytes() {
                Object ref = this.clientId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.clientId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setClientId(String value) {
                if (value == null) {
                  throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.clientId_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.clientId_ = Message.MessageBase.getDefaultInstance().getClientId();
                onChanged();
                return this;
            }

            public Builder setClientIdBytes(ByteString value) {
                if (value == null) {
                  throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.clientId_ = value;
                onChanged();
                return this;
            }

            public boolean hasCmd() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public Command.CommandType getCmd() {
                Command.CommandType result = Command.CommandType.valueOf(this.cmd_);
                return (result == null) ? Command.CommandType.AUTH : result;
            }

            public Builder setCmd(Command.CommandType value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.cmd_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearCmd() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.cmd_ = 1;
                onChanged();
                return this;
            }

            public boolean hasData() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public String getData() {
                Object ref = this.data_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.data_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getDataBytes() {
                Object ref = this.data_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.data_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setData(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.data_ = value;
                onChanged();
                return this;
            }

            public Builder clearData() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.data_ = Message.MessageBase.getDefaultInstance().getData();
                onChanged();
                return this;
            }

            public Builder setDataBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.data_ = value;
                onChanged();
                return this;
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return (Builder) super.setUnknownFields(unknownFields);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return (Builder) super.mergeUnknownFields(unknownFields);
            }
        }

        private static final MessageBase DEFAULT_INSTANCE = new MessageBase();

        public static MessageBase getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @Deprecated
        public static final Parser<MessageBase> PARSER = (Parser<MessageBase>) new AbstractParser<MessageBase>() {
            public Message.MessageBase parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Message.MessageBase(input, extensionRegistry);
            }
        };

        public static Parser<MessageBase> parser() {
            return PARSER;
        }

        public Parser<MessageBase> getParserForType() {
            return PARSER;
        }

        public MessageBase getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class MessageGo extends GeneratedMessageV3 implements MessageGoOrBuilder {
        private int bitField0_;

        public static final int CLIENTID_FIELD_NUMBER = 1;

        private volatile Object clientId_;

        public static final int CMD_FIELD_NUMBER = 2;

        private int cmd_;

        public static final int LON_FIELD_NUMBER = 3;

        private volatile Object lon_;

        public static final int LAT_FIELD_NUMBER = 4;

        private volatile Object lat_;

        private byte memoizedIsInitialized;

        private static final long serialVersionUID = 0L;

        private MessageGo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MessageGo() {
            this.memoizedIsInitialized = -1;
            this.clientId_ = "";
            this.cmd_ = 1;
            this.lon_ = "";
            this.lat_ = "";
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MessageGo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString byteString1;
                    int rawValue;
                    ByteString bs;
                    Command.CommandType value;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10:
                            byteString1 = input.readBytes();
                            this.bitField0_ |= 0x1;
                            this.clientId_ = byteString1;
                            break;
                        case 16:
                            rawValue = input.readEnum();
                            value = Command.CommandType.valueOf(rawValue);
                            if (value == null) {
                                unknownFields.mergeVarintField(2, rawValue);
                                break;
                            }
                            this.bitField0_ |= 0x2;
                            this.cmd_ = rawValue;
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.lon_ = bs;
                            break;
                        case 34:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x8;
                            this.lat_ = bs;
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e)).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Message.internal_static_cn_myzf_common_protobuf_MessageGo_descriptor;
        }

        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Message.internal_static_cn_myzf_common_protobuf_MessageGo_fieldAccessorTable.ensureFieldAccessorsInitialized(MessageGo.class, Builder.class);
        }

        public boolean hasClientId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getClientId() {
            Object ref = this.clientId_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.clientId_ = s;
            return s;
        }

        public ByteString getClientIdBytes() {
            Object ref = this.clientId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.clientId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasCmd() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public Command.CommandType getCmd() {
            Command.CommandType result = Command.CommandType.valueOf(this.cmd_);
            return (result == null) ? Command.CommandType.AUTH : result;
        }

        public boolean hasLon() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public String getLon() {
            Object ref = this.lon_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.lon_ = s;
            return s;
        }

        public ByteString getLonBytes() {
            Object ref = this.lon_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.lon_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasLat() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public String getLat() {
            Object ref = this.lat_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.lat_ = s;
            return s;
        }

        public ByteString getLatBytes() {
            Object ref = this.lat_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.lat_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasClientId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasCmd()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasLon()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasLat()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if ((this.bitField0_ & 0x1) == 1)
                GeneratedMessageV3.writeString(output, 1, this.clientId_);
            if ((this.bitField0_ & 0x2) == 2)
                output.writeEnum(2, this.cmd_);
            if ((this.bitField0_ & 0x4) == 4)
                GeneratedMessageV3.writeString(output, 3, this.lon_);
            if ((this.bitField0_ & 0x8) == 8)
                GeneratedMessageV3.writeString(output, 4, this.lat_);
            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += GeneratedMessageV3.computeStringSize(1, this.clientId_);
            if ((this.bitField0_ & 0x2) == 2)
                size +=
                        CodedOutputStream.computeEnumSize(2, this.cmd_);
            if ((this.bitField0_ & 0x4) == 4)
                size += GeneratedMessageV3.computeStringSize(3, this.lon_);
            if ((this.bitField0_ & 0x8) == 8)
                size += GeneratedMessageV3.computeStringSize(4, this.lat_);
            size += this.unknownFields.getSerializedSize();
            this.memoizedSize = size;
            return size;
        }

        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (!(obj instanceof MessageGo))
                return super.equals(obj);
            MessageGo other = (MessageGo) obj;
            boolean result = true;
            result = (result && hasClientId() == other.hasClientId());
            if (hasClientId())
                result = (result && getClientId().equals(other.getClientId()));
            result = (result && hasCmd() == other.hasCmd());
            if (hasCmd())
                result = (result && this.cmd_ == other.cmd_);
            result = (result && hasLon() == other.hasLon());
            if (hasLon())
                result = (result && getLon().equals(other.getLon()));
            result = (result && hasLat() == other.hasLat());
            if (hasLat())
                result = (result && getLat().equals(other.getLat()));
            result = (result && this.unknownFields.equals(other.unknownFields));
            return result;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0)
                return this.memoizedHashCode;
            int hash = 41;
            hash = 19 * hash + getDescriptor().hashCode();
            if (hasClientId()) {
                hash = 37 * hash + 1;
                hash = 53 * hash + getClientId().hashCode();
            }
            if (hasCmd()) {
                hash = 37 * hash + 2;
                hash = 53 * hash + this.cmd_;
            }
            if (hasLon()) {
                hash = 37 * hash + 3;
                hash = 53 * hash + getLon().hashCode();
            }
            if (hasLat()) {
                hash = 37 * hash + 4;
                hash = 53 * hash + getLat().hashCode();
            }
            hash = 29 * hash + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static MessageGo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (MessageGo) PARSER.parseFrom(data);
        }

        public static MessageGo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MessageGo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MessageGo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MessageGo) PARSER.parseFrom(data);
        }

        public static MessageGo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MessageGo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MessageGo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MessageGo) PARSER.parseFrom(data);
        }

        public static MessageGo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MessageGo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MessageGo parseFrom(InputStream input) throws IOException {
            return
                    (MessageGo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MessageGo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return
                    (MessageGo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MessageGo parseDelimitedFrom(InputStream input) throws IOException {
            return
                    (MessageGo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MessageGo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return
                    (MessageGo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MessageGo parseFrom(CodedInputStream input) throws IOException {
            return
                    (MessageGo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MessageGo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return
                    (MessageGo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MessageGo prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder())
                    .mergeFrom(this);
        }

        protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Message.MessageGoOrBuilder {
            private int bitField0_;

            private Object clientId_;

            private int cmd_;

            private Object lon_;

            private Object lat_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Message.internal_static_cn_myzf_common_protobuf_MessageGo_descriptor;
            }

            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Message.internal_static_cn_myzf_common_protobuf_MessageGo_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(Message.MessageGo.class, Builder.class);
            }

            private Builder() {
                this.clientId_ = "";
                this.cmd_ = 1;
                this.lon_ = "";
                this.lat_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                this.clientId_ = "";
                this.cmd_ = 1;
                this.lon_ = "";
                this.lat_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Message.MessageGo.alwaysUseFieldBuilders) ;
            }

            public Builder clear() {
                super.clear();
                this.clientId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.cmd_ = 1;
                this.bitField0_ &= 0xFFFFFFFD;
                this.lon_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                this.lat_ = "";
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Message.internal_static_cn_myzf_common_protobuf_MessageGo_descriptor;
            }

            public Message.MessageGo getDefaultInstanceForType() {
                return Message.MessageGo.getDefaultInstance();
            }

            public Message.MessageGo build() {
                Message.MessageGo result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public Message.MessageGo buildPartial() {
                Message.MessageGo result = new Message.MessageGo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.clientId_ = this.clientId_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.cmd_ = this.cmd_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.lon_ = this.lon_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.lat_ = this.lat_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder setField(Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.setField(field, value);
            }

            public Builder clearField(Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }

            public Builder clearOneof(Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }

            public Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }

            public Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }

            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof Message.MessageGo)
                    return mergeFrom((Message.MessageGo) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Message.MessageGo other) {
                if (other == Message.MessageGo.getDefaultInstance())
                    return this;
                if (other.hasClientId()) {
                    this.bitField0_ |= 0x1;
                    this.clientId_ = other.clientId_;
                    onChanged();
                }
                if (other.hasCmd())
                    setCmd(other.getCmd());
                if (other.hasLon()) {
                    this.bitField0_ |= 0x4;
                    this.lon_ = other.lon_;
                    onChanged();
                }
                if (other.hasLat()) {
                    this.bitField0_ |= 0x8;
                    this.lat_ = other.lat_;
                    onChanged();
                }
                mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                if (!hasClientId())
                    return false;
                if (!hasCmd())
                    return false;
                if (!hasLon())
                    return false;
                if (!hasLat())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Message.MessageGo parsedMessage = null;
                try {
                    parsedMessage = (Message.MessageGo) Message.MessageGo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Message.MessageGo) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasClientId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getClientId() {
                Object ref = this.clientId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.clientId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getClientIdBytes() {
                Object ref = this.clientId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.clientId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setClientId(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.clientId_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.clientId_ = Message.MessageGo.getDefaultInstance().getClientId();
                onChanged();
                return this;
            }

            public Builder setClientIdBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.clientId_ = value;
                onChanged();
                return this;
            }

            public boolean hasCmd() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public Command.CommandType getCmd() {
                Command.CommandType result = Command.CommandType.valueOf(this.cmd_);
                return (result == null) ? Command.CommandType.AUTH : result;
            }

            public Builder setCmd(Command.CommandType value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.cmd_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearCmd() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.cmd_ = 1;
                onChanged();
                return this;
            }

            public boolean hasLon() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public String getLon() {
                Object ref = this.lon_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.lon_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getLonBytes() {
                Object ref = this.lon_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.lon_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setLon(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.lon_ = value;
                onChanged();
                return this;
            }

            public Builder clearLon() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.lon_ = Message.MessageGo.getDefaultInstance().getLon();
                onChanged();
                return this;
            }

            public Builder setLonBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.lon_ = value;
                onChanged();
                return this;
            }

            public boolean hasLat() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public String getLat() {
                Object ref = this.lat_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.lat_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getLatBytes() {
                Object ref = this.lat_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.lat_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setLat(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x8;
                this.lat_ = value;
                onChanged();
                return this;
            }

            public Builder clearLat() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.lat_ = Message.MessageGo.getDefaultInstance().getLat();
                onChanged();
                return this;
            }

            public Builder setLatBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x8;
                this.lat_ = value;
                onChanged();
                return this;
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return (Builder) super.setUnknownFields(unknownFields);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return (Builder) super.mergeUnknownFields(unknownFields);
            }
        }

        private static final MessageGo DEFAULT_INSTANCE = new MessageGo();

        public static MessageGo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @Deprecated
        public static final Parser<MessageGo> PARSER = (Parser<MessageGo>) new AbstractParser<MessageGo>() {
            public Message.MessageGo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Message.MessageGo(input, extensionRegistry);
            }
        };

        public static Parser<MessageGo> parser() {
            return PARSER;
        }

        public Parser<MessageGo> getParserForType() {
            return PARSER;
        }

        public MessageGo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class MessageArrive extends GeneratedMessageV3 implements MessageArriveOrBuilder {
        private int bitField0_;

        public static final int CLIENTID_FIELD_NUMBER = 1;

        private volatile Object clientId_;

        public static final int CMD_FIELD_NUMBER = 2;

        private int cmd_;

        public static final int ARRIVE_FIELD_NUMBER = 3;

        private volatile Object arrive_;

        public static final int LON_FIELD_NUMBER = 4;

        private volatile Object lon_;

        public static final int LAT_FIELD_NUMBER = 5;

        private volatile Object lat_;

        private byte memoizedIsInitialized;

        private static final long serialVersionUID = 0L;

        private MessageArrive(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MessageArrive() {
            this.memoizedIsInitialized = -1;
            this.clientId_ = "";
            this.cmd_ = 1;
            this.arrive_ = "";
            this.lon_ = "";
            this.lat_ = "";
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MessageArrive(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString byteString1;
                    int rawValue;
                    ByteString bs;
                    Command.CommandType value;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10:
                            byteString1 = input.readBytes();
                            this.bitField0_ |= 0x1;
                            this.clientId_ = byteString1;
                            break;
                        case 16:
                            rawValue = input.readEnum();
                            value = Command.CommandType.valueOf(rawValue);
                            if (value == null) {
                                unknownFields.mergeVarintField(2, rawValue);
                                break;
                            }
                            this.bitField0_ |= 0x2;
                            this.cmd_ = rawValue;
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.arrive_ = bs;
                            break;
                        case 34:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x8;
                            this.lon_ = bs;
                            break;
                        case 42:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x10;
                            this.lat_ = bs;
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e)).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Message.internal_static_cn_myzf_common_protobuf_MessageArrive_descriptor;
        }

        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Message.internal_static_cn_myzf_common_protobuf_MessageArrive_fieldAccessorTable.ensureFieldAccessorsInitialized(MessageArrive.class, Builder.class);
        }

        public boolean hasClientId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getClientId() {
            Object ref = this.clientId_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.clientId_ = s;
            return s;
        }

        public ByteString getClientIdBytes() {
            Object ref = this.clientId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.clientId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasCmd() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public Command.CommandType getCmd() {
            Command.CommandType result = Command.CommandType.valueOf(this.cmd_);
            return (result == null) ? Command.CommandType.AUTH : result;
        }

        public boolean hasArrive() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public String getArrive() {
            Object ref = this.arrive_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.arrive_ = s;
            return s;
        }

        public ByteString getArriveBytes() {
            Object ref = this.arrive_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.arrive_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasLon() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public String getLon() {
            Object ref = this.lon_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.lon_ = s;
            return s;
        }

        public ByteString getLonBytes() {
            Object ref = this.lon_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.lon_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasLat() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public String getLat() {
            Object ref = this.lat_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.lat_ = s;
            return s;
        }

        public ByteString getLatBytes() {
            Object ref = this.lat_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.lat_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasClientId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasCmd()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasArrive()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if ((this.bitField0_ & 0x1) == 1)
                GeneratedMessageV3.writeString(output, 1, this.clientId_);
            if ((this.bitField0_ & 0x2) == 2)
                output.writeEnum(2, this.cmd_);
            if ((this.bitField0_ & 0x4) == 4)
                GeneratedMessageV3.writeString(output, 3, this.arrive_);
            if ((this.bitField0_ & 0x8) == 8)
                GeneratedMessageV3.writeString(output, 4, this.lon_);
            if ((this.bitField0_ & 0x10) == 16)
                GeneratedMessageV3.writeString(output, 5, this.lat_);
            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += GeneratedMessageV3.computeStringSize(1, this.clientId_);
            if ((this.bitField0_ & 0x2) == 2)
                size +=
                        CodedOutputStream.computeEnumSize(2, this.cmd_);
            if ((this.bitField0_ & 0x4) == 4)
                size += GeneratedMessageV3.computeStringSize(3, this.arrive_);
            if ((this.bitField0_ & 0x8) == 8)
                size += GeneratedMessageV3.computeStringSize(4, this.lon_);
            if ((this.bitField0_ & 0x10) == 16)
                size += GeneratedMessageV3.computeStringSize(5, this.lat_);
            size += this.unknownFields.getSerializedSize();
            this.memoizedSize = size;
            return size;
        }

        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (!(obj instanceof MessageArrive))
                return super.equals(obj);
            MessageArrive other = (MessageArrive) obj;
            boolean result = true;
            result = (result && hasClientId() == other.hasClientId());
            if (hasClientId())
                result = (result && getClientId().equals(other.getClientId()));
            result = (result && hasCmd() == other.hasCmd());
            if (hasCmd())
                result = (result && this.cmd_ == other.cmd_);
            result = (result && hasArrive() == other.hasArrive());
            if (hasArrive())
                result = (result && getArrive().equals(other.getArrive()));
            result = (result && hasLon() == other.hasLon());
            if (hasLon())
                result = (result && getLon().equals(other.getLon()));
            result = (result && hasLat() == other.hasLat());
            if (hasLat())
                result = (result && getLat().equals(other.getLat()));
            result = (result && this.unknownFields.equals(other.unknownFields));
            return result;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0)
                return this.memoizedHashCode;
            int hash = 41;
            hash = 19 * hash + getDescriptor().hashCode();
            if (hasClientId()) {
                hash = 37 * hash + 1;
                hash = 53 * hash + getClientId().hashCode();
            }
            if (hasCmd()) {
                hash = 37 * hash + 2;
                hash = 53 * hash + this.cmd_;
            }
            if (hasArrive()) {
                hash = 37 * hash + 3;
                hash = 53 * hash + getArrive().hashCode();
            }
            if (hasLon()) {
                hash = 37 * hash + 4;
                hash = 53 * hash + getLon().hashCode();
            }
            if (hasLat()) {
                hash = 37 * hash + 5;
                hash = 53 * hash + getLat().hashCode();
            }
            hash = 29 * hash + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static MessageArrive parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (MessageArrive) PARSER.parseFrom(data);
        }

        public static MessageArrive parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MessageArrive) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MessageArrive parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MessageArrive) PARSER.parseFrom(data);
        }

        public static MessageArrive parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MessageArrive) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MessageArrive parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MessageArrive) PARSER.parseFrom(data);
        }

        public static MessageArrive parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MessageArrive) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MessageArrive parseFrom(InputStream input) throws IOException {
            return
                    (MessageArrive) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MessageArrive parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return
                    (MessageArrive) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MessageArrive parseDelimitedFrom(InputStream input) throws IOException {
            return
                    (MessageArrive) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MessageArrive parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return
                    (MessageArrive) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MessageArrive parseFrom(CodedInputStream input) throws IOException {
            return
                    (MessageArrive) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MessageArrive parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return
                    (MessageArrive) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MessageArrive prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder())
                    .mergeFrom(this);
        }

        protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Message.MessageArriveOrBuilder {
            private int bitField0_;

            private Object clientId_;

            private int cmd_;

            private Object arrive_;

            private Object lon_;

            private Object lat_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Message.internal_static_cn_myzf_common_protobuf_MessageArrive_descriptor;
            }

            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Message.internal_static_cn_myzf_common_protobuf_MessageArrive_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(Message.MessageArrive.class, Builder.class);
            }

            private Builder() {
                this.clientId_ = "";
                this.cmd_ = 1;
                this.arrive_ = "";
                this.lon_ = "";
                this.lat_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                this.clientId_ = "";
                this.cmd_ = 1;
                this.arrive_ = "";
                this.lon_ = "";
                this.lat_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Message.MessageArrive.alwaysUseFieldBuilders) ;
            }

            public Builder clear() {
                super.clear();
                this.clientId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.cmd_ = 1;
                this.bitField0_ &= 0xFFFFFFFD;
                this.arrive_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                this.lon_ = "";
                this.bitField0_ &= 0xFFFFFFF7;
                this.lat_ = "";
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Message.internal_static_cn_myzf_common_protobuf_MessageArrive_descriptor;
            }

            public Message.MessageArrive getDefaultInstanceForType() {
                return Message.MessageArrive.getDefaultInstance();
            }

            public Message.MessageArrive build() {
                Message.MessageArrive result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public Message.MessageArrive buildPartial() {
                Message.MessageArrive result = new Message.MessageArrive(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.clientId_ = this.clientId_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.cmd_ = this.cmd_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.arrive_ = this.arrive_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.lon_ = this.lon_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.lat_ = this.lat_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder setField(Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.setField(field, value);
            }

            public Builder clearField(Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }

            public Builder clearOneof(Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }

            public Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }

            public Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }

            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof Message.MessageArrive)
                    return mergeFrom((Message.MessageArrive) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Message.MessageArrive other) {
                if (other == Message.MessageArrive.getDefaultInstance())
                    return this;
                if (other.hasClientId()) {
                    this.bitField0_ |= 0x1;
                    this.clientId_ = other.clientId_;
                    onChanged();
                }
                if (other.hasCmd())
                    setCmd(other.getCmd());
                if (other.hasArrive()) {
                    this.bitField0_ |= 0x4;
                    this.arrive_ = other.arrive_;
                    onChanged();
                }
                if (other.hasLon()) {
                    this.bitField0_ |= 0x8;
                    this.lon_ = other.lon_;
                    onChanged();
                }
                if (other.hasLat()) {
                    this.bitField0_ |= 0x10;
                    this.lat_ = other.lat_;
                    onChanged();
                }
                mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                if (!hasClientId())
                    return false;
                if (!hasCmd())
                    return false;
                if (!hasArrive())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Message.MessageArrive parsedMessage = null;
                try {
                    parsedMessage = (Message.MessageArrive) Message.MessageArrive.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Message.MessageArrive) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasClientId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getClientId() {
                Object ref = this.clientId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.clientId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getClientIdBytes() {
                Object ref = this.clientId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.clientId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setClientId(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.clientId_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.clientId_ = Message.MessageArrive.getDefaultInstance().getClientId();
                onChanged();
                return this;
            }

            public Builder setClientIdBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.clientId_ = value;
                onChanged();
                return this;
            }

            public boolean hasCmd() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public Command.CommandType getCmd() {
                Command.CommandType result = Command.CommandType.valueOf(this.cmd_);
                return (result == null) ? Command.CommandType.AUTH : result;
            }

            public Builder setCmd(Command.CommandType value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.cmd_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearCmd() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.cmd_ = 1;
                onChanged();
                return this;
            }

            public boolean hasArrive() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public String getArrive() {
                Object ref = this.arrive_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.arrive_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getArriveBytes() {
                Object ref = this.arrive_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.arrive_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setArrive(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.arrive_ = value;
                onChanged();
                return this;
            }

            public Builder clearArrive() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.arrive_ = Message.MessageArrive.getDefaultInstance().getArrive();
                onChanged();
                return this;
            }

            public Builder setArriveBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.arrive_ = value;
                onChanged();
                return this;
            }

            public boolean hasLon() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public String getLon() {
                Object ref = this.lon_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.lon_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getLonBytes() {
                Object ref = this.lon_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.lon_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setLon(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x8;
                this.lon_ = value;
                onChanged();
                return this;
            }

            public Builder clearLon() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.lon_ = Message.MessageArrive.getDefaultInstance().getLon();
                onChanged();
                return this;
            }

            public Builder setLonBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x8;
                this.lon_ = value;
                onChanged();
                return this;
            }

            public boolean hasLat() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public String getLat() {
                Object ref = this.lat_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.lat_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getLatBytes() {
                Object ref = this.lat_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.lat_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setLat(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x10;
                this.lat_ = value;
                onChanged();
                return this;
            }

            public Builder clearLat() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.lat_ = Message.MessageArrive.getDefaultInstance().getLat();
                onChanged();
                return this;
            }

            public Builder setLatBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x10;
                this.lat_ = value;
                onChanged();
                return this;
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return (Builder) super.setUnknownFields(unknownFields);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return (Builder) super.mergeUnknownFields(unknownFields);
            }
        }

        private static final MessageArrive DEFAULT_INSTANCE = new MessageArrive();

        public static MessageArrive getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @Deprecated
        public static final Parser<MessageArrive> PARSER = (Parser<MessageArrive>) new AbstractParser<MessageArrive>() {
            public Message.MessageArrive parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Message.MessageArrive(input, extensionRegistry);
            }
        };

        public static Parser<MessageArrive> parser() {
            return PARSER;
        }

        public Parser<MessageArrive> getParserForType() {
            return PARSER;
        }

        public MessageArrive getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class MessageGeneralBiz extends GeneratedMessageV3 implements MessageGeneralBizOrBuilder {
        private int bitField0_;

        public static final int CLIENTID_FIELD_NUMBER = 1;

        private volatile Object clientId_;

        public static final int CMD_FIELD_NUMBER = 2;

        private int cmd_;

        public static final int DATA_FIELD_NUMBER = 3;

        private volatile Object data_;

        private byte memoizedIsInitialized;

        private static final long serialVersionUID = 0L;

        private MessageGeneralBiz(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MessageGeneralBiz() {
            this.memoizedIsInitialized = -1;
            this.clientId_ = "";
            this.cmd_ = 1;
            this.data_ = "";
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MessageGeneralBiz(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString byteString1;
                    int rawValue;
                    ByteString bs;
                    Command.CommandType value;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10:
                            byteString1 = input.readBytes();
                            this.bitField0_ |= 0x1;
                            this.clientId_ = byteString1;
                            break;
                        case 16:
                            rawValue = input.readEnum();
                            value = Command.CommandType.valueOf(rawValue);
                            if (value == null) {
                                unknownFields.mergeVarintField(2, rawValue);
                                break;
                            }
                            this.bitField0_ |= 0x2;
                            this.cmd_ = rawValue;
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.data_ = bs;
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e)).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Message.internal_static_cn_myzf_common_protobuf_MessageGeneralBiz_descriptor;
        }

        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Message.internal_static_cn_myzf_common_protobuf_MessageGeneralBiz_fieldAccessorTable.ensureFieldAccessorsInitialized(MessageGeneralBiz.class, Builder.class);
        }

        public boolean hasClientId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getClientId() {
            Object ref = this.clientId_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.clientId_ = s;
            return s;
        }

        public ByteString getClientIdBytes() {
            Object ref = this.clientId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.clientId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasCmd() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public Command.CommandType getCmd() {
            Command.CommandType result = Command.CommandType.valueOf(this.cmd_);
            return (result == null) ? Command.CommandType.AUTH : result;
        }

        public boolean hasData() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public String getData() {
            Object ref = this.data_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.data_ = s;
            return s;
        }

        public ByteString getDataBytes() {
            Object ref = this.data_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.data_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasClientId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasCmd()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if ((this.bitField0_ & 0x1) == 1)
                GeneratedMessageV3.writeString(output, 1, this.clientId_);
            if ((this.bitField0_ & 0x2) == 2)
                output.writeEnum(2, this.cmd_);
            if ((this.bitField0_ & 0x4) == 4)
                GeneratedMessageV3.writeString(output, 3, this.data_);
            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += GeneratedMessageV3.computeStringSize(1, this.clientId_);
            if ((this.bitField0_ & 0x2) == 2)
                size +=
                        CodedOutputStream.computeEnumSize(2, this.cmd_);
            if ((this.bitField0_ & 0x4) == 4)
                size += GeneratedMessageV3.computeStringSize(3, this.data_);
            size += this.unknownFields.getSerializedSize();
            this.memoizedSize = size;
            return size;
        }

        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (!(obj instanceof MessageGeneralBiz))
                return super.equals(obj);
            MessageGeneralBiz other = (MessageGeneralBiz) obj;
            boolean result = true;
            result = (result && hasClientId() == other.hasClientId());
            if (hasClientId())
                result = (result && getClientId().equals(other.getClientId()));
            result = (result && hasCmd() == other.hasCmd());
            if (hasCmd())
                result = (result && this.cmd_ == other.cmd_);
            result = (result && hasData() == other.hasData());
            if (hasData())
                result = (result && getData().equals(other.getData()));
            result = (result && this.unknownFields.equals(other.unknownFields));
            return result;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0)
                return this.memoizedHashCode;
            int hash = 41;
            hash = 19 * hash + getDescriptor().hashCode();
            if (hasClientId()) {
                hash = 37 * hash + 1;
                hash = 53 * hash + getClientId().hashCode();
            }
            if (hasCmd()) {
                hash = 37 * hash + 2;
                hash = 53 * hash + this.cmd_;
            }
            if (hasData()) {
                hash = 37 * hash + 3;
                hash = 53 * hash + getData().hashCode();
            }
            hash = 29 * hash + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static MessageGeneralBiz parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (MessageGeneralBiz) PARSER.parseFrom(data);
        }

        public static MessageGeneralBiz parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MessageGeneralBiz) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MessageGeneralBiz parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MessageGeneralBiz) PARSER.parseFrom(data);
        }

        public static MessageGeneralBiz parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MessageGeneralBiz) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MessageGeneralBiz parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MessageGeneralBiz) PARSER.parseFrom(data);
        }

        public static MessageGeneralBiz parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MessageGeneralBiz) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MessageGeneralBiz parseFrom(InputStream input) throws IOException {
            return
                    (MessageGeneralBiz) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MessageGeneralBiz parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return
                    (MessageGeneralBiz) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MessageGeneralBiz parseDelimitedFrom(InputStream input) throws IOException {
            return
                    (MessageGeneralBiz) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MessageGeneralBiz parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return
                    (MessageGeneralBiz) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MessageGeneralBiz parseFrom(CodedInputStream input) throws IOException {
            return
                    (MessageGeneralBiz) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MessageGeneralBiz parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return
                    (MessageGeneralBiz) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MessageGeneralBiz prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder())
                    .mergeFrom(this);
        }

        protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Message.MessageGeneralBizOrBuilder {
            private int bitField0_;

            private Object clientId_;

            private int cmd_;

            private Object data_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Message.internal_static_cn_myzf_common_protobuf_MessageGeneralBiz_descriptor;
            }

            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Message.internal_static_cn_myzf_common_protobuf_MessageGeneralBiz_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(Message.MessageGeneralBiz.class, Builder.class);
            }

            private Builder() {
                this.clientId_ = "";
                this.cmd_ = 1;
                this.data_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                this.clientId_ = "";
                this.cmd_ = 1;
                this.data_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Message.MessageGeneralBiz.alwaysUseFieldBuilders) ;
            }

            public Builder clear() {
                super.clear();
                this.clientId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.cmd_ = 1;
                this.bitField0_ &= 0xFFFFFFFD;
                this.data_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Message.internal_static_cn_myzf_common_protobuf_MessageGeneralBiz_descriptor;
            }

            public Message.MessageGeneralBiz getDefaultInstanceForType() {
                return Message.MessageGeneralBiz.getDefaultInstance();
            }

            public Message.MessageGeneralBiz build() {
                Message.MessageGeneralBiz result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public Message.MessageGeneralBiz buildPartial() {
                Message.MessageGeneralBiz result = new Message.MessageGeneralBiz(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.clientId_ = this.clientId_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.cmd_ = this.cmd_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.data_ = this.data_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder setField(Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.setField(field, value);
            }

            public Builder clearField(Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }

            public Builder clearOneof(Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }

            public Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }

            public Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }

            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof Message.MessageGeneralBiz)
                    return mergeFrom((Message.MessageGeneralBiz) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Message.MessageGeneralBiz other) {
                if (other == Message.MessageGeneralBiz.getDefaultInstance())
                    return this;
                if (other.hasClientId()) {
                    this.bitField0_ |= 0x1;
                    this.clientId_ = other.clientId_;
                    onChanged();
                }
                if (other.hasCmd())
                    setCmd(other.getCmd());
                if (other.hasData()) {
                    this.bitField0_ |= 0x4;
                    this.data_ = other.data_;
                    onChanged();
                }
                mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                if (!hasClientId())
                    return false;
                if (!hasCmd())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Message.MessageGeneralBiz parsedMessage = null;
                try {
                    parsedMessage = (Message.MessageGeneralBiz) Message.MessageGeneralBiz.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Message.MessageGeneralBiz) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasClientId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getClientId() {
                Object ref = this.clientId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.clientId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getClientIdBytes() {
                Object ref = this.clientId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.clientId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setClientId(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.clientId_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.clientId_ = Message.MessageGeneralBiz.getDefaultInstance().getClientId();
                onChanged();
                return this;
            }

            public Builder setClientIdBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.clientId_ = value;
                onChanged();
                return this;
            }

            public boolean hasCmd() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public Command.CommandType getCmd() {
                Command.CommandType result = Command.CommandType.valueOf(this.cmd_);
                return (result == null) ? Command.CommandType.AUTH : result;
            }

            public Builder setCmd(Command.CommandType value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.cmd_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearCmd() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.cmd_ = 1;
                onChanged();
                return this;
            }

            public boolean hasData() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public String getData() {
                Object ref = this.data_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.data_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getDataBytes() {
                Object ref = this.data_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.data_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setData(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.data_ = value;
                onChanged();
                return this;
            }

            public Builder clearData() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.data_ = Message.MessageGeneralBiz.getDefaultInstance().getData();
                onChanged();
                return this;
            }

            public Builder setDataBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.data_ = value;
                onChanged();
                return this;
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return (Builder) super.setUnknownFields(unknownFields);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return (Builder) super.mergeUnknownFields(unknownFields);
            }
        }

        private static final MessageGeneralBiz DEFAULT_INSTANCE = new MessageGeneralBiz();

        public static MessageGeneralBiz getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @Deprecated
        public static final Parser<MessageGeneralBiz> PARSER = (Parser<MessageGeneralBiz>) new AbstractParser<MessageGeneralBiz>() {
            public Message.MessageGeneralBiz parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Message.MessageGeneralBiz(input, extensionRegistry);
            }
        };

        public static Parser<MessageGeneralBiz> parser() {
            return PARSER;
        }

        public Parser<MessageGeneralBiz> getParserForType() {
            return PARSER;
        }

        public MessageGeneralBiz getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class MessageData extends GeneratedMessageV3 implements MessageDataOrBuilder {
        private int bitField0_;

        private int dataMsgCase_;

        private Object dataMsg_;

        public static final int TYPE_FIELD_NUMBER = 1;

        private int type_;

        public static final int MESSAGEBASE_FIELD_NUMBER = 2;

        public static final int MESSAGEGO_FIELD_NUMBER = 3;

        public static final int MESSAGEARRIVE_FIELD_NUMBER = 4;

        public static final int MESSAGEGENERALBIZ_FIELD_NUMBER = 5;

        private byte memoizedIsInitialized;

        private static final long serialVersionUID = 0L;

        private MessageData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.dataMsgCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private MessageData() {
            this.dataMsgCase_ = 0;
            this.memoizedIsInitialized = -1;
            this.type_ = 1;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MessageData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int rawValue;
                    Message.MessageBase.Builder builder2;
                    Message.MessageGo.Builder builder1;
                    Message.MessageArrive.Builder builder;
                    Message.MessageGeneralBiz.Builder subBuilder;
                    DataType value;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 8:
                            rawValue = input.readEnum();
                            value = DataType.valueOf(rawValue);
                            if (value == null) {
                                unknownFields.mergeVarintField(1, rawValue);
                                break;
                            }
                            this.bitField0_ |= 0x1;
                            this.type_ = rawValue;
                            break;
                        case 18:
                            builder2 = null;
                            if (this.dataMsgCase_ == 2)
                                builder2 = ((Message.MessageBase) this.dataMsg_).toBuilder();
                            this.dataMsg_ = input.readMessage(Message.MessageBase.PARSER, extensionRegistry);
                            if (builder2 != null) {
                                builder2.mergeFrom((Message.MessageBase) this.dataMsg_);
                                this.dataMsg_ = builder2.buildPartial();
                            }
                            this.dataMsgCase_ = 2;
                            break;
                        case 26:
                            builder1 = null;
                            if (this.dataMsgCase_ == 3)
                                builder1 = ((Message.MessageGo) this.dataMsg_).toBuilder();
                            this.dataMsg_ = input.readMessage(Message.MessageGo.PARSER, extensionRegistry);
                            if (builder1 != null) {
                                builder1.mergeFrom((Message.MessageGo) this.dataMsg_);
                                this.dataMsg_ = builder1.buildPartial();
                            }
                            this.dataMsgCase_ = 3;
                            break;
                        case 34:
                            builder = null;
                            if (this.dataMsgCase_ == 4)
                                builder = ((Message.MessageArrive) this.dataMsg_).toBuilder();
                            this.dataMsg_ = input.readMessage(Message.MessageArrive.PARSER, extensionRegistry);
                            if (builder != null) {
                                builder.mergeFrom((Message.MessageArrive) this.dataMsg_);
                                this.dataMsg_ = builder.buildPartial();
                            }
                            this.dataMsgCase_ = 4;
                            break;
                        case 42:
                            subBuilder = null;
                            if (this.dataMsgCase_ == 5)
                                subBuilder = ((Message.MessageGeneralBiz) this.dataMsg_).toBuilder();
                            this.dataMsg_ = input.readMessage(Message.MessageGeneralBiz.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom((Message.MessageGeneralBiz) this.dataMsg_);
                                this.dataMsg_ = subBuilder.buildPartial();
                            }
                            this.dataMsgCase_ = 5;
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e)).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Message.internal_static_cn_myzf_common_protobuf_MessageData_descriptor;
        }

        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Message.internal_static_cn_myzf_common_protobuf_MessageData_fieldAccessorTable.ensureFieldAccessorsInitialized(MessageData.class, Builder.class);
        }

        public enum DataType implements ProtocolMessageEnum {
            MessageBase(1),
            MessageGo(2),
            MessageArrive(3),
            MessageGeneralBiz(4);

            public static final int MessageBase_VALUE = 1;

            public static final int MessageGo_VALUE = 2;

            public static final int MessageArrive_VALUE = 3;

            public static final int MessageGeneralBiz_VALUE = 4;

            private static final Internal.EnumLiteMap<DataType> internalValueMap = new Internal.EnumLiteMap<DataType>() {
                public Message.MessageData.DataType findValueByNumber(int number) {
                    return Message.MessageData.DataType.forNumber(number);
                }
            };

            private static final DataType[] VALUES = values();

            private final int value;

            public final int getNumber() {
                return this.value;
            }

            public static DataType forNumber(int value) {
                switch (value) {
                    case 1:
                        return MessageBase;
                    case 2:
                        return MessageGo;
                    case 3:
                        return MessageArrive;
                    case 4:
                        return MessageGeneralBiz;
                }
                return null;
            }

            public static Internal.EnumLiteMap<DataType> internalGetValueMap() {
                return internalValueMap;
            }

            static {

            }

            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                return getDescriptor().getValues().get(ordinal());
            }

            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return Message.MessageData.getDescriptor().getEnumTypes().get(0);
            }

            DataType(int value) {
                this.value = value;
            }
        }

        public enum DataMsgCase implements Internal.EnumLite {
            MESSAGEBASE(2),
            MESSAGEGO(3),
            MESSAGEARRIVE(4),
            MESSAGEGENERALBIZ(5),
            DATAMSG_NOT_SET(0);

            private final int value;

            DataMsgCase(int value) {
                this.value = value;
            }

            public static DataMsgCase forNumber(int value) {
                switch (value) {
                    case 2:
                        return MESSAGEBASE;
                    case 3:
                        return MESSAGEGO;
                    case 4:
                        return MESSAGEARRIVE;
                    case 5:
                        return MESSAGEGENERALBIZ;
                    case 0:
                        return DATAMSG_NOT_SET;
                }
                return null;
            }

            public int getNumber() {
                return this.value;
            }
        }

        public DataMsgCase getDataMsgCase() {
            return DataMsgCase.forNumber(this.dataMsgCase_);
        }

        public boolean hasType() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public DataType getType() {
            DataType result = DataType.valueOf(this.type_);
            return (result == null) ? DataType.MessageBase : result;
        }

        public boolean hasMessageBase() {
            return (this.dataMsgCase_ == 2);
        }

        public Message.MessageBase getMessageBase() {
            if (this.dataMsgCase_ == 2)
                return (Message.MessageBase) this.dataMsg_;
            return Message.MessageBase.getDefaultInstance();
        }

        public Message.MessageBaseOrBuilder getMessageBaseOrBuilder() {
            if (this.dataMsgCase_ == 2)
                return (Message.MessageBase) this.dataMsg_;
            return Message.MessageBase.getDefaultInstance();
        }

        public boolean hasMessageGo() {
            return (this.dataMsgCase_ == 3);
        }

        public Message.MessageGo getMessageGo() {
            if (this.dataMsgCase_ == 3)
                return (Message.MessageGo) this.dataMsg_;
            return Message.MessageGo.getDefaultInstance();
        }

        public Message.MessageGoOrBuilder getMessageGoOrBuilder() {
            if (this.dataMsgCase_ == 3)
                return (Message.MessageGo) this.dataMsg_;
            return Message.MessageGo.getDefaultInstance();
        }

        public boolean hasMessageArrive() {
            return (this.dataMsgCase_ == 4);
        }

        public Message.MessageArrive getMessageArrive() {
            if (this.dataMsgCase_ == 4)
                return (Message.MessageArrive) this.dataMsg_;
            return Message.MessageArrive.getDefaultInstance();
        }

        public Message.MessageArriveOrBuilder getMessageArriveOrBuilder() {
            if (this.dataMsgCase_ == 4)
                return (Message.MessageArrive) this.dataMsg_;
            return Message.MessageArrive.getDefaultInstance();
        }

        public boolean hasMessageGeneralBiz() {
            return (this.dataMsgCase_ == 5);
        }

        public Message.MessageGeneralBiz getMessageGeneralBiz() {
            if (this.dataMsgCase_ == 5)
                return (Message.MessageGeneralBiz) this.dataMsg_;
            return Message.MessageGeneralBiz.getDefaultInstance();
        }

        public Message.MessageGeneralBizOrBuilder getMessageGeneralBizOrBuilder() {
            if (this.dataMsgCase_ == 5)
                return (Message.MessageGeneralBiz) this.dataMsg_;
            return Message.MessageGeneralBiz.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasType()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (hasMessageBase() &&
                    !getMessageBase().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (hasMessageGo() &&
                    !getMessageGo().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (hasMessageArrive() &&
                    !getMessageArrive().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (hasMessageGeneralBiz() &&
                    !getMessageGeneralBiz().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if ((this.bitField0_ & 0x1) == 1)
                output.writeEnum(1, this.type_);
            if (this.dataMsgCase_ == 2)
                output.writeMessage(2, (MessageLite) this.dataMsg_);
            if (this.dataMsgCase_ == 3)
                output.writeMessage(3, (MessageLite) this.dataMsg_);
            if (this.dataMsgCase_ == 4)
                output.writeMessage(4, (MessageLite) this.dataMsg_);
            if (this.dataMsgCase_ == 5)
                output.writeMessage(5, (MessageLite) this.dataMsg_);
            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size +=
                        CodedOutputStream.computeEnumSize(1, this.type_);
            if (this.dataMsgCase_ == 2)
                size +=
                        CodedOutputStream.computeMessageSize(2, (MessageLite) this.dataMsg_);
            if (this.dataMsgCase_ == 3)
                size +=
                        CodedOutputStream.computeMessageSize(3, (MessageLite) this.dataMsg_);
            if (this.dataMsgCase_ == 4)
                size +=
                        CodedOutputStream.computeMessageSize(4, (MessageLite) this.dataMsg_);
            if (this.dataMsgCase_ == 5)
                size +=
                        CodedOutputStream.computeMessageSize(5, (MessageLite) this.dataMsg_);
            size += this.unknownFields.getSerializedSize();
            this.memoizedSize = size;
            return size;
        }

        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (!(obj instanceof MessageData))
                return super.equals(obj);
            MessageData other = (MessageData) obj;
            boolean result = true;
            result = (result && hasType() == other.hasType());
            if (hasType())
                result = (result && this.type_ == other.type_);
            result = (result && getDataMsgCase().equals(other
                    .getDataMsgCase()));
            if (!result)
                return false;
            switch (this.dataMsgCase_) {
                case 2:
                    result = (result && getMessageBase().equals(other.getMessageBase()));
                    break;
                case 3:
                    result = (result && getMessageGo().equals(other.getMessageGo()));
                    break;
                case 4:
                    result = (result && getMessageArrive().equals(other.getMessageArrive()));
                    break;
                case 5:
                    result = (result && getMessageGeneralBiz().equals(other.getMessageGeneralBiz()));
                    break;
            }
            result = (result && this.unknownFields.equals(other.unknownFields));
            return result;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0)
                return this.memoizedHashCode;
            int hash = 41;
            hash = 19 * hash + getDescriptor().hashCode();
            if (hasType()) {
                hash = 37 * hash + 1;
                hash = 53 * hash + this.type_;
            }
            switch (this.dataMsgCase_) {
                case 2:
                    hash = 37 * hash + 2;
                    hash = 53 * hash + getMessageBase().hashCode();
                    break;
                case 3:
                    hash = 37 * hash + 3;
                    hash = 53 * hash + getMessageGo().hashCode();
                    break;
                case 4:
                    hash = 37 * hash + 4;
                    hash = 53 * hash + getMessageArrive().hashCode();
                    break;
                case 5:
                    hash = 37 * hash + 5;
                    hash = 53 * hash + getMessageGeneralBiz().hashCode();
                    break;
            }
            hash = 29 * hash + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static MessageData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (MessageData) PARSER.parseFrom(data);
        }

        public static MessageData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MessageData) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MessageData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MessageData) PARSER.parseFrom(data);
        }

        public static MessageData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MessageData) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MessageData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MessageData) PARSER.parseFrom(data);
        }

        public static MessageData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MessageData) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MessageData parseFrom(InputStream input) throws IOException {
            return
                    (MessageData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MessageData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return
                    (MessageData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MessageData parseDelimitedFrom(InputStream input) throws IOException {
            return
                    (MessageData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MessageData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return
                    (MessageData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MessageData parseFrom(CodedInputStream input) throws IOException {
            return
                    (MessageData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MessageData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return
                    (MessageData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MessageData prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder())
                    .mergeFrom(this);
        }

        protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Message.MessageDataOrBuilder {
            private int dataMsgCase_;

            private Object dataMsg_;

            private int bitField0_;

            private int type_;

            private SingleFieldBuilderV3<Message.MessageBase, Message.MessageBase.Builder, Message.MessageBaseOrBuilder> messageBaseBuilder_;

            private SingleFieldBuilderV3<Message.MessageGo, Message.MessageGo.Builder, Message.MessageGoOrBuilder> messageGoBuilder_;

            private SingleFieldBuilderV3<Message.MessageArrive, Message.MessageArrive.Builder, Message.MessageArriveOrBuilder> messageArriveBuilder_;

            private SingleFieldBuilderV3<Message.MessageGeneralBiz, Message.MessageGeneralBiz.Builder, Message.MessageGeneralBizOrBuilder> messageGeneralBizBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Message.internal_static_cn_myzf_common_protobuf_MessageData_descriptor;
            }

            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Message.internal_static_cn_myzf_common_protobuf_MessageData_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(Message.MessageData.class, Builder.class);
            }

            private Builder() {
                this.dataMsgCase_ = 0;
                this.type_ = 1;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                this.dataMsgCase_ = 0;
                this.type_ = 1;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Message.MessageData.alwaysUseFieldBuilders) ;
            }

            public Builder clear() {
                super.clear();
                this.type_ = 1;
                this.bitField0_ &= 0xFFFFFFFE;
                this.dataMsgCase_ = 0;
                this.dataMsg_ = null;
                return this;
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Message.internal_static_cn_myzf_common_protobuf_MessageData_descriptor;
            }

            public Message.MessageData getDefaultInstanceForType() {
                return Message.MessageData.getDefaultInstance();
            }

            public Message.MessageData build() {
                Message.MessageData result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public Message.MessageData buildPartial() {
                Message.MessageData result = new Message.MessageData(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.type_ = this.type_;
                if (this.dataMsgCase_ == 2)
                    if (this.messageBaseBuilder_ == null) {
                        result.dataMsg_ = this.dataMsg_;
                    } else {
                        result.dataMsg_ = this.messageBaseBuilder_.build();
                    }
                if (this.dataMsgCase_ == 3)
                    if (this.messageGoBuilder_ == null) {
                        result.dataMsg_ = this.dataMsg_;
                    } else {
                        result.dataMsg_ = this.messageGoBuilder_.build();
                    }
                if (this.dataMsgCase_ == 4)
                    if (this.messageArriveBuilder_ == null) {
                        result.dataMsg_ = this.dataMsg_;
                    } else {
                        result.dataMsg_ = this.messageArriveBuilder_.build();
                    }
                if (this.dataMsgCase_ == 5)
                    if (this.messageGeneralBizBuilder_ == null) {
                        result.dataMsg_ = this.dataMsg_;
                    } else {
                        result.dataMsg_ = this.messageGeneralBizBuilder_.build();
                    }
                result.bitField0_ = to_bitField0_;
                result.dataMsgCase_ = this.dataMsgCase_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder setField(Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.setField(field, value);
            }

            public Builder clearField(Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }

            public Builder clearOneof(Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }

            public Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }

            public Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }

            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof Message.MessageData)
                    return mergeFrom((Message.MessageData) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Message.MessageData other) {
                if (other == Message.MessageData.getDefaultInstance())
                    return this;
                if (other.hasType())
                    setType(other.getType());
                switch (other.getDataMsgCase()) {
                    case MESSAGEBASE:
                        mergeMessageBase(other.getMessageBase());
                        break;
                    case MESSAGEGO:
                        mergeMessageGo(other.getMessageGo());
                        break;
                    case MESSAGEARRIVE:
                        mergeMessageArrive(other.getMessageArrive());
                        break;
                    case MESSAGEGENERALBIZ:
                        mergeMessageGeneralBiz(other.getMessageGeneralBiz());
                        break;
                }
                mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                if (!hasType())
                    return false;
                if (hasMessageBase() && !getMessageBase().isInitialized())
                    return false;
                if (hasMessageGo() && !getMessageGo().isInitialized())
                    return false;
                if (hasMessageArrive() && !getMessageArrive().isInitialized())
                    return false;
                if (hasMessageGeneralBiz() && !getMessageGeneralBiz().isInitialized())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Message.MessageData parsedMessage = null;
                try {
                    parsedMessage = (Message.MessageData) Message.MessageData.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Message.MessageData) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public Message.MessageData.DataMsgCase getDataMsgCase() {
                return Message.MessageData.DataMsgCase.forNumber(this.dataMsgCase_);
            }

            public Builder clearDataMsg() {
                this.dataMsgCase_ = 0;
                this.dataMsg_ = null;
                onChanged();
                return this;
            }

            public boolean hasType() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public Message.MessageData.DataType getType() {
                Message.MessageData.DataType result = Message.MessageData.DataType.valueOf(this.type_);
                return (result == null) ? Message.MessageData.DataType.MessageBase : result;
            }

            public Builder setType(Message.MessageData.DataType value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.type_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.type_ = 1;
                onChanged();
                return this;
            }

            public boolean hasMessageBase() {
                return (this.dataMsgCase_ == 2);
            }

            public Message.MessageBase getMessageBase() {
                if (this.messageBaseBuilder_ == null) {
                    if (this.dataMsgCase_ == 2)
                        return (Message.MessageBase) this.dataMsg_;
                    return Message.MessageBase.getDefaultInstance();
                }
                if (this.dataMsgCase_ == 2)
                    return (Message.MessageBase) this.messageBaseBuilder_.getMessage();
                return Message.MessageBase.getDefaultInstance();
            }

            public Builder setMessageBase(Message.MessageBase value) {
                if (this.messageBaseBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.dataMsg_ = value;
                    onChanged();
                } else {
                    this.messageBaseBuilder_.setMessage((AbstractMessage) value);
                }
                this.dataMsgCase_ = 2;
                return this;
            }

            public Builder setMessageBase(Message.MessageBase.Builder builderForValue) {
                if (this.messageBaseBuilder_ == null) {
                    this.dataMsg_ = builderForValue.build();
                    onChanged();
                } else {
                    this.messageBaseBuilder_.setMessage((AbstractMessage) builderForValue.build());
                }
                this.dataMsgCase_ = 2;
                return this;
            }

            public Builder mergeMessageBase(Message.MessageBase value) {
                if (this.messageBaseBuilder_ == null) {
                    if (this.dataMsgCase_ == 2 && this.dataMsg_ !=
                            Message.MessageBase.getDefaultInstance()) {
                        this
                                .dataMsg_ = Message.MessageBase.newBuilder((Message.MessageBase) this.dataMsg_).mergeFrom(value).buildPartial();
                    } else {
                        this.dataMsg_ = value;
                    }
                    onChanged();
                } else {
                    if (this.dataMsgCase_ == 2)
                        this.messageBaseBuilder_.mergeFrom((AbstractMessage) value);
                    this.messageBaseBuilder_.setMessage((AbstractMessage) value);
                }
                this.dataMsgCase_ = 2;
                return this;
            }

            public Builder clearMessageBase() {
                if (this.messageBaseBuilder_ == null) {
                    if (this.dataMsgCase_ == 2) {
                        this.dataMsgCase_ = 0;
                        this.dataMsg_ = null;
                        onChanged();
                    }
                } else {
                    if (this.dataMsgCase_ == 2) {
                        this.dataMsgCase_ = 0;
                        this.dataMsg_ = null;
                    }
                    this.messageBaseBuilder_.clear();
                }
                return this;
            }

            public Message.MessageBase.Builder getMessageBaseBuilder() {
                return (Message.MessageBase.Builder) getMessageBaseFieldBuilder().getBuilder();
            }

            public Message.MessageBaseOrBuilder getMessageBaseOrBuilder() {
                if (this.dataMsgCase_ == 2 && this.messageBaseBuilder_ != null)
                    return (Message.MessageBaseOrBuilder) this.messageBaseBuilder_.getMessageOrBuilder();
                if (this.dataMsgCase_ == 2)
                    return (Message.MessageBase) this.dataMsg_;
                return Message.MessageBase.getDefaultInstance();
            }

            private SingleFieldBuilderV3<Message.MessageBase, Message.MessageBase.Builder, Message.MessageBaseOrBuilder> getMessageBaseFieldBuilder() {
                if (this.messageBaseBuilder_ == null) {
                    if (this.dataMsgCase_ != 2)
                        this.dataMsg_ = Message.MessageBase.getDefaultInstance();
                    this

                            .messageBaseBuilder_ = new SingleFieldBuilderV3((AbstractMessage) this.dataMsg_, (AbstractMessage.BuilderParent) getParentForChildren(), isClean());
                    this.dataMsg_ = null;
                }
                this.dataMsgCase_ = 2;
                onChanged();
                return this.messageBaseBuilder_;
            }

            public boolean hasMessageGo() {
                return (this.dataMsgCase_ == 3);
            }

            public Message.MessageGo getMessageGo() {
                if (this.messageGoBuilder_ == null) {
                    if (this.dataMsgCase_ == 3)
                        return (Message.MessageGo) this.dataMsg_;
                    return Message.MessageGo.getDefaultInstance();
                }
                if (this.dataMsgCase_ == 3)
                    return (Message.MessageGo) this.messageGoBuilder_.getMessage();
                return Message.MessageGo.getDefaultInstance();
            }

            public Builder setMessageGo(Message.MessageGo value) {
                if (this.messageGoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.dataMsg_ = value;
                    onChanged();
                } else {
                    this.messageGoBuilder_.setMessage((AbstractMessage) value);
                }
                this.dataMsgCase_ = 3;
                return this;
            }

            public Builder setMessageGo(Message.MessageGo.Builder builderForValue) {
                if (this.messageGoBuilder_ == null) {
                    this.dataMsg_ = builderForValue.build();
                    onChanged();
                } else {
                    this.messageGoBuilder_.setMessage((AbstractMessage) builderForValue.build());
                }
                this.dataMsgCase_ = 3;
                return this;
            }

            public Builder mergeMessageGo(Message.MessageGo value) {
                if (this.messageGoBuilder_ == null) {
                    if (this.dataMsgCase_ == 3 && this.dataMsg_ !=
                            Message.MessageGo.getDefaultInstance()) {
                        this
                                .dataMsg_ = Message.MessageGo.newBuilder((Message.MessageGo) this.dataMsg_).mergeFrom(value).buildPartial();
                    } else {
                        this.dataMsg_ = value;
                    }
                    onChanged();
                } else {
                    if (this.dataMsgCase_ == 3)
                        this.messageGoBuilder_.mergeFrom((AbstractMessage) value);
                    this.messageGoBuilder_.setMessage((AbstractMessage) value);
                }
                this.dataMsgCase_ = 3;
                return this;
            }

            public Builder clearMessageGo() {
                if (this.messageGoBuilder_ == null) {
                    if (this.dataMsgCase_ == 3) {
                        this.dataMsgCase_ = 0;
                        this.dataMsg_ = null;
                        onChanged();
                    }
                } else {
                    if (this.dataMsgCase_ == 3) {
                        this.dataMsgCase_ = 0;
                        this.dataMsg_ = null;
                    }
                    this.messageGoBuilder_.clear();
                }
                return this;
            }

            public Message.MessageGo.Builder getMessageGoBuilder() {
                return (Message.MessageGo.Builder) getMessageGoFieldBuilder().getBuilder();
            }

            public Message.MessageGoOrBuilder getMessageGoOrBuilder() {
                if (this.dataMsgCase_ == 3 && this.messageGoBuilder_ != null)
                    return (Message.MessageGoOrBuilder) this.messageGoBuilder_.getMessageOrBuilder();
                if (this.dataMsgCase_ == 3)
                    return (Message.MessageGo) this.dataMsg_;
                return Message.MessageGo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<Message.MessageGo, Message.MessageGo.Builder, Message.MessageGoOrBuilder> getMessageGoFieldBuilder() {
                if (this.messageGoBuilder_ == null) {
                    if (this.dataMsgCase_ != 3)
                        this.dataMsg_ = Message.MessageGo.getDefaultInstance();
                    this

                            .messageGoBuilder_ = new SingleFieldBuilderV3((AbstractMessage) this.dataMsg_, (AbstractMessage.BuilderParent) getParentForChildren(), isClean());
                    this.dataMsg_ = null;
                }
                this.dataMsgCase_ = 3;
                onChanged();
                return this.messageGoBuilder_;
            }

            public boolean hasMessageArrive() {
                return (this.dataMsgCase_ == 4);
            }

            public Message.MessageArrive getMessageArrive() {
                if (this.messageArriveBuilder_ == null) {
                    if (this.dataMsgCase_ == 4)
                        return (Message.MessageArrive) this.dataMsg_;
                    return Message.MessageArrive.getDefaultInstance();
                }
                if (this.dataMsgCase_ == 4)
                    return (Message.MessageArrive) this.messageArriveBuilder_.getMessage();
                return Message.MessageArrive.getDefaultInstance();
            }

            public Builder setMessageArrive(Message.MessageArrive value) {
                if (this.messageArriveBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.dataMsg_ = value;
                    onChanged();
                } else {
                    this.messageArriveBuilder_.setMessage((AbstractMessage) value);
                }
                this.dataMsgCase_ = 4;
                return this;
            }

            public Builder setMessageArrive(Message.MessageArrive.Builder builderForValue) {
                if (this.messageArriveBuilder_ == null) {
                    this.dataMsg_ = builderForValue.build();
                    onChanged();
                } else {
                    this.messageArriveBuilder_.setMessage((AbstractMessage) builderForValue.build());
                }
                this.dataMsgCase_ = 4;
                return this;
            }

            public Builder mergeMessageArrive(Message.MessageArrive value) {
                if (this.messageArriveBuilder_ == null) {
                    if (this.dataMsgCase_ == 4 && this.dataMsg_ !=
                            Message.MessageArrive.getDefaultInstance()) {
                        this
                                .dataMsg_ = Message.MessageArrive.newBuilder((Message.MessageArrive) this.dataMsg_).mergeFrom(value).buildPartial();
                    } else {
                        this.dataMsg_ = value;
                    }
                    onChanged();
                } else {
                    if (this.dataMsgCase_ == 4)
                        this.messageArriveBuilder_.mergeFrom((AbstractMessage) value);
                    this.messageArriveBuilder_.setMessage((AbstractMessage) value);
                }
                this.dataMsgCase_ = 4;
                return this;
            }

            public Builder clearMessageArrive() {
                if (this.messageArriveBuilder_ == null) {
                    if (this.dataMsgCase_ == 4) {
                        this.dataMsgCase_ = 0;
                        this.dataMsg_ = null;
                        onChanged();
                    }
                } else {
                    if (this.dataMsgCase_ == 4) {
                        this.dataMsgCase_ = 0;
                        this.dataMsg_ = null;
                    }
                    this.messageArriveBuilder_.clear();
                }
                return this;
            }

            public Message.MessageArrive.Builder getMessageArriveBuilder() {
                return (Message.MessageArrive.Builder) getMessageArriveFieldBuilder().getBuilder();
            }

            public Message.MessageArriveOrBuilder getMessageArriveOrBuilder() {
                if (this.dataMsgCase_ == 4 && this.messageArriveBuilder_ != null)
                    return (Message.MessageArriveOrBuilder) this.messageArriveBuilder_.getMessageOrBuilder();
                if (this.dataMsgCase_ == 4)
                    return (Message.MessageArrive) this.dataMsg_;
                return Message.MessageArrive.getDefaultInstance();
            }

            private SingleFieldBuilderV3<Message.MessageArrive, Message.MessageArrive.Builder, Message.MessageArriveOrBuilder> getMessageArriveFieldBuilder() {
                if (this.messageArriveBuilder_ == null) {
                    if (this.dataMsgCase_ != 4)
                        this.dataMsg_ = Message.MessageArrive.getDefaultInstance();
                    this

                            .messageArriveBuilder_ = new SingleFieldBuilderV3((AbstractMessage) this.dataMsg_, (AbstractMessage.BuilderParent) getParentForChildren(), isClean());
                    this.dataMsg_ = null;
                }
                this.dataMsgCase_ = 4;
                onChanged();
                return this.messageArriveBuilder_;
            }

            public boolean hasMessageGeneralBiz() {
                return (this.dataMsgCase_ == 5);
            }

            public Message.MessageGeneralBiz getMessageGeneralBiz() {
                if (this.messageGeneralBizBuilder_ == null) {
                    if (this.dataMsgCase_ == 5)
                        return (Message.MessageGeneralBiz) this.dataMsg_;
                    return Message.MessageGeneralBiz.getDefaultInstance();
                }
                if (this.dataMsgCase_ == 5)
                    return (Message.MessageGeneralBiz) this.messageGeneralBizBuilder_.getMessage();
                return Message.MessageGeneralBiz.getDefaultInstance();
            }

            public Builder setMessageGeneralBiz(Message.MessageGeneralBiz value) {
                if (this.messageGeneralBizBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.dataMsg_ = value;
                    onChanged();
                } else {
                    this.messageGeneralBizBuilder_.setMessage((AbstractMessage) value);
                }
                this.dataMsgCase_ = 5;
                return this;
            }

            public Builder setMessageGeneralBiz(Message.MessageGeneralBiz.Builder builderForValue) {
                if (this.messageGeneralBizBuilder_ == null) {
                    this.dataMsg_ = builderForValue.build();
                    onChanged();
                } else {
                    this.messageGeneralBizBuilder_.setMessage((AbstractMessage) builderForValue.build());
                }
                this.dataMsgCase_ = 5;
                return this;
            }

            public Builder mergeMessageGeneralBiz(Message.MessageGeneralBiz value) {
                if (this.messageGeneralBizBuilder_ == null) {
                    if (this.dataMsgCase_ == 5 && this.dataMsg_ !=
                            Message.MessageGeneralBiz.getDefaultInstance()) {
                        this
                                .dataMsg_ = Message.MessageGeneralBiz.newBuilder((Message.MessageGeneralBiz) this.dataMsg_).mergeFrom(value).buildPartial();
                    } else {
                        this.dataMsg_ = value;
                    }
                    onChanged();
                } else {
                    if (this.dataMsgCase_ == 5)
                        this.messageGeneralBizBuilder_.mergeFrom((AbstractMessage) value);
                    this.messageGeneralBizBuilder_.setMessage((AbstractMessage) value);
                }
                this.dataMsgCase_ = 5;
                return this;
            }

            public Builder clearMessageGeneralBiz() {
                if (this.messageGeneralBizBuilder_ == null) {
                    if (this.dataMsgCase_ == 5) {
                        this.dataMsgCase_ = 0;
                        this.dataMsg_ = null;
                        onChanged();
                    }
                } else {
                    if (this.dataMsgCase_ == 5) {
                        this.dataMsgCase_ = 0;
                        this.dataMsg_ = null;
                    }
                    this.messageGeneralBizBuilder_.clear();
                }
                return this;
            }

            public Message.MessageGeneralBiz.Builder getMessageGeneralBizBuilder() {
                return (Message.MessageGeneralBiz.Builder) getMessageGeneralBizFieldBuilder().getBuilder();
            }

            public Message.MessageGeneralBizOrBuilder getMessageGeneralBizOrBuilder() {
                if (this.dataMsgCase_ == 5 && this.messageGeneralBizBuilder_ != null)
                    return (Message.MessageGeneralBizOrBuilder) this.messageGeneralBizBuilder_.getMessageOrBuilder();
                if (this.dataMsgCase_ == 5)
                    return (Message.MessageGeneralBiz) this.dataMsg_;
                return Message.MessageGeneralBiz.getDefaultInstance();
            }

            private SingleFieldBuilderV3<Message.MessageGeneralBiz, Message.MessageGeneralBiz.Builder, Message.MessageGeneralBizOrBuilder> getMessageGeneralBizFieldBuilder() {
                if (this.messageGeneralBizBuilder_ == null) {
                    if (this.dataMsgCase_ != 5)
                        this.dataMsg_ = Message.MessageGeneralBiz.getDefaultInstance();
                    this

                            .messageGeneralBizBuilder_ = new SingleFieldBuilderV3((AbstractMessage) this.dataMsg_, (AbstractMessage.BuilderParent) getParentForChildren(), isClean());
                    this.dataMsg_ = null;
                }
                this.dataMsgCase_ = 5;
                onChanged();
                return this.messageGeneralBizBuilder_;
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return (Builder) super.setUnknownFields(unknownFields);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return (Builder) super.mergeUnknownFields(unknownFields);
            }
        }

        private static final MessageData DEFAULT_INSTANCE = new MessageData();

        public static MessageData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @Deprecated
        public static final Parser<MessageData> PARSER = (Parser<MessageData>) new AbstractParser<MessageData>() {
            public Message.MessageData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Message.MessageData(input, extensionRegistry);
            }
        };

        public static Parser<MessageData> parser() {
            return PARSER;
        }

        public Parser<MessageData> getParserForType() {
            return PARSER;
        }

        public MessageData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        String[] descriptorData = {"\n\rMessage.proto\022\027cn.myzf.common.protobuf\032\rCommand.proto\"`\n\013MessageBase\022\020\n\bclientId\030\001 \002(\t\0221\n\003cmd\030\002 \002(\0162$.cn.myzf.common.protobuf.CommandType\022\f\n\004data\030\003 \001(\t\"j\n\tMessageGo\022\020\n\bclientId\030\001 \002(\t\0221\n\003cmd\030\002 \002(\0162$.cn.myzf.common.protobuf.CommandType\022\013\n\003lon\030\003 \002(\t\022\013\n\003lat\030\004 \002(\t\"~\n\rMessageArrive\022\020\n\bclientId\030\001 \002(\t\0221\n\003cmd\030\002 \002(\0162$.cn.myzf.common.protobuf.CommandType\022\016\n\006arrive\030\003 \002(\t\022\013\n\003lon\030\004 \001(\t\022\013\n\003lat\030\005 \001(\t\"f\n\021Message", "GeneralBiz\022\020\n\bclientId\030\001 \002(\t\0221\n\003cmd\030\002 \002(\0162$.cn.myzf.common.protobuf.CommandType\022\f\n\004data\030\003 \001(\t\"\003\n\013MessageData\022H\n\004type\030\001 \002(\0162-.cn.myzf.common.protobuf.MessageData.DataType:\013MessageBase\022;\n\013messageBase\030\002 \001(\0132$.cn.myzf.common.protobuf.MessageBaseH\000\0227\n\tmessageGo\030\003 \001(\0132\".cn.myzf.common.protobuf.MessageGoH\000\022?\n\rmessageArrive\030\004 \001(\0132&.cn.myzf.common.protobuf.MessageArriveH\000\022G\n\021messageGeneralBiz\030\005 \001(\0132*.cn.m", "yzf.common.protobuf.MessageGeneralBizH\000\"T\n\bDataType\022\017\n\013MessageBase\020\001\022\r\n\tMessageGo\020\002\022\021\n\rMessageArrive\020\003\022\025\n\021MessageGeneralBiz\020\004B\t\n\007dataMsg"};
        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                Message.descriptor = root;
                return null;
            }
        };
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{Command.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_cn_myzf_common_protobuf_MessageBase_descriptor = getDescriptor().getMessageTypes().get(0);

    private static final GeneratedMessageV3.FieldAccessorTable internal_static_cn_myzf_common_protobuf_MessageBase_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_cn_myzf_common_protobuf_MessageBase_descriptor, new String[]{"ClientId", "Cmd", "Data"});

    private static final Descriptors.Descriptor internal_static_cn_myzf_common_protobuf_MessageGo_descriptor = getDescriptor().getMessageTypes().get(1);

    private static final GeneratedMessageV3.FieldAccessorTable internal_static_cn_myzf_common_protobuf_MessageGo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_cn_myzf_common_protobuf_MessageGo_descriptor, new String[]{"ClientId", "Cmd", "Lon", "Lat"});

    private static final Descriptors.Descriptor internal_static_cn_myzf_common_protobuf_MessageArrive_descriptor = getDescriptor().getMessageTypes().get(2);

    private static final GeneratedMessageV3.FieldAccessorTable internal_static_cn_myzf_common_protobuf_MessageArrive_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_cn_myzf_common_protobuf_MessageArrive_descriptor, new String[]{"ClientId", "Cmd", "Arrive", "Lon", "Lat"});

    private static final Descriptors.Descriptor internal_static_cn_myzf_common_protobuf_MessageGeneralBiz_descriptor = getDescriptor().getMessageTypes().get(3);

    private static final GeneratedMessageV3.FieldAccessorTable internal_static_cn_myzf_common_protobuf_MessageGeneralBiz_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_cn_myzf_common_protobuf_MessageGeneralBiz_descriptor, new String[]{"ClientId", "Cmd", "Data"});

    private static final Descriptors.Descriptor internal_static_cn_myzf_common_protobuf_MessageData_descriptor = getDescriptor().getMessageTypes().get(4);

    private static final GeneratedMessageV3.FieldAccessorTable internal_static_cn_myzf_common_protobuf_MessageData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_cn_myzf_common_protobuf_MessageData_descriptor, new String[]{"Type", "MessageBase", "MessageGo", "MessageArrive", "MessageGeneralBiz", "DataMsg"});

    private static Descriptors.FileDescriptor descriptor;

    static {
        Command.getDescriptor();
    }

    public static interface MessageDataOrBuilder extends MessageOrBuilder {
        boolean hasType();

        Message.MessageData.DataType getType();

        boolean hasMessageBase();

        Message.MessageBase getMessageBase();

        Message.MessageBaseOrBuilder getMessageBaseOrBuilder();

        boolean hasMessageGo();

        Message.MessageGo getMessageGo();

        Message.MessageGoOrBuilder getMessageGoOrBuilder();

        boolean hasMessageArrive();

        Message.MessageArrive getMessageArrive();

        Message.MessageArriveOrBuilder getMessageArriveOrBuilder();

        boolean hasMessageGeneralBiz();

        Message.MessageGeneralBiz getMessageGeneralBiz();

        Message.MessageGeneralBizOrBuilder getMessageGeneralBizOrBuilder();

        Message.MessageData.DataMsgCase getDataMsgCase();
    }

    public static interface MessageGeneralBizOrBuilder extends MessageOrBuilder {
        boolean hasClientId();

        String getClientId();

        ByteString getClientIdBytes();

        boolean hasCmd();

        Command.CommandType getCmd();

        boolean hasData();

        String getData();

        ByteString getDataBytes();
    }

    public static interface MessageArriveOrBuilder extends MessageOrBuilder {
        boolean hasClientId();

        String getClientId();

        ByteString getClientIdBytes();

        boolean hasCmd();

        Command.CommandType getCmd();

        boolean hasArrive();

        String getArrive();

        ByteString getArriveBytes();

        boolean hasLon();

        String getLon();

        ByteString getLonBytes();

        boolean hasLat();

        String getLat();

        ByteString getLatBytes();
    }

    public static interface MessageGoOrBuilder extends MessageOrBuilder {
        boolean hasClientId();

        String getClientId();

        ByteString getClientIdBytes();

        boolean hasCmd();

        Command.CommandType getCmd();

        boolean hasLon();

        String getLon();

        ByteString getLonBytes();

        boolean hasLat();

        String getLat();

        ByteString getLatBytes();
    }

    public static interface MessageBaseOrBuilder extends MessageOrBuilder {
        boolean hasClientId();

        String getClientId();

        ByteString getClientIdBytes();

        boolean hasCmd();

        Command.CommandType getCmd();

        boolean hasData();

        String getData();

        ByteString getDataBytes();
    }
}

